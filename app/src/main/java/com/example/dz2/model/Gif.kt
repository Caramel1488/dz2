package com.example.dz2.model

import com.google.gson.annotations.SerializedName

data class Gif(
    @SerializedName( "images")
    val images: ImagesData,

    )