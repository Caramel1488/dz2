package com.example.dz2.networking

import com.example.dz2.BuildConfig
import com.example.dz2.Gif
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GifService {

    @GET("v1/gifs/search")
    suspend fun searchGifs(
        @Query("q") query: String,
        @Query("offset") page: Int,
        @Query("limit") itemsPerPage: Int
    ): GifSearchResponse

    companion object {
        fun create(): GifService {
            val okHttpClient = OkHttpClient.Builder()
                .addNetworkInterceptor(
                    CustomHeaderInterceptor(
                        "X-RapidAPI-Key",
                        BuildConfig.X_RAPIDAPI_KEY
                    )
                )
                .addNetworkInterceptor(
                    CustomHeaderInterceptor(
                        "X-RapidAPI-Host",
                        BuildConfig.X_RAPIDAPI_HOST
                    )
                )
                .addInterceptor(
                    CustomParamInterceptor("api_key", BuildConfig.API_KEY)
                )
                .build()

            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(GifService::class.java)
        }
    }
}