package com.example.dz2.model

import com.google.gson.annotations.SerializedName

data class OriginalData(
    @SerializedName("url")
    val url: String,
    @SerializedName("mp4")
    val mp4: String
)