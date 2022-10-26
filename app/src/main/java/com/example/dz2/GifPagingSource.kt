package com.example.dz2

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.dz2.networking.GifService
import retrofit2.HttpException
import java.io.IOException

private const val GIF_STARTING_PAGE_INDEX = 1
const val ITEMS_PER_PAGE = 15

class GifPagingSource(
    private val service: GifService,
    private val query: String
) : PagingSource<Int, Gif>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Gif> {
        val position = params.key ?: GIF_STARTING_PAGE_INDEX
        val apiQuery = query

        return try {
            val response = service.searchGifs(query, position * ITEMS_PER_PAGE, ITEMS_PER_PAGE)
            val gifs = response.data
            val nextKey = if (gifs.isEmpty()) {
                null
            } else {
                position + (params.loadSize / ITEMS_PER_PAGE)
            }
            LoadResult.Page(
                data = gifs,
                prevKey = if (position == GIF_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = nextKey
            )
        }catch (exception: IOException){
            return LoadResult.Error(exception)
        }catch (exception: HttpException){
            return LoadResult.Error(exception)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, Gif>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}