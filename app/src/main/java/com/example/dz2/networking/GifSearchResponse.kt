package com.example.dz2.networking

import com.google.gson.annotations.SerializedName

data class GifSearchResponse(
    @SerializedName("pagination.total_count") val total: Int,
    @SerializedName("data") val data: List<Gif>,
    val nextPage: Int?
)