package com.example.dz2.networking

import com.google.gson.annotations.SerializedName

data class ImagesData(
    @SerializedName("original")
    val original: OriginalData
)