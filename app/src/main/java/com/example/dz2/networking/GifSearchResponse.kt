package com.example.dz2.networking

import com.example.dz2.Gif
import com.google.gson.annotations.SerializedName

import com.squareup.moshi.JsonClass

data class GifSearchResponse(
    @SerializedName("total_count") val total: Int = 0,
    @SerializedName("data") val data: List<Gif> = emptyList(),
    val nextPage: Int? = null
)