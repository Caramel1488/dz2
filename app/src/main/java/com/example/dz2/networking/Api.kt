package com.example.dz2.networking

import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/")
    suspend fun getGifs(
        @Query("q") query:String
    ):GifSearchResponse
}

/*

val client = OkHttpClient()

val request = Request.Builder()
	.url("https://giphy.p.rapidapi.com/v1/gifs/search?api_key=j7ZDazcK1qALCHh6iDrZkUAH66G6jMjh&q=star")
	.get()
	.addHeader("X-RapidAPI-Key", "6ce670f88cmshebd8f983236869cp193451jsn067ebd2a404e")
	.addHeader("X-RapidAPI-Host", "giphy.p.rapidapi.com")
	.build()

val response = client.newCall(request).execute()*/

//https://giphy.com/embed/LWFXXqaSEmO7twXDxP
//