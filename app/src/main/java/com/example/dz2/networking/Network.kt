package com.example.dz2.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object Network {
    private const val API_KEY = "j7ZDazcK1qALCHh6iDrZkUAH66G6jMjh"
    private val okHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(
            CustomParamInterceptor("api_key", API_KEY)
        )
        .addNetworkInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://giphy.p.rapidapi.com/v1/gifs/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val gifApi: Api
        get() = retrofit.create()
}