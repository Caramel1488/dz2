package com.example.dz2

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.dz2.networking.GifService
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

class GifRepository(private val service: GifService) {

    fun getSearchResultStream(query: String): Flow<PagingData<Gif>>{
        return Pager(
            config = PagingConfig(
                pageSize = ITEMS_PER_PAGE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {GifPagingSource(service, query)}
        ).flow
    }

}