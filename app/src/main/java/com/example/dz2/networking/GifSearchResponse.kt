package com.example.dz2.networking

import com.example.dz2.model.Gif
import com.example.dz2.model.PaginationData
import com.google.gson.annotations.SerializedName

data class GifSearchResponse(
    @SerializedName("pagination") val pagination: PaginationData,
    @SerializedName("data") val data: List<Gif>,
    val nextPage: Int?
)