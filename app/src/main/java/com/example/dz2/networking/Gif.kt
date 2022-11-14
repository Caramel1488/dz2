package com.example.dz2.networking

import com.google.gson.annotations.SerializedName

data class Gif(
    @SerializedName( "images")
    val images: ImagesData,

)