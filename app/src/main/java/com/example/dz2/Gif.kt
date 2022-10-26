package com.example.dz2

import com.google.gson.annotations.SerializedName

data class Gif(
    @SerializedName( "url")
    val url: String,
    @SerializedName( "slug")
    val slug: String,
    @SerializedName( "bitly_gif_url")
    val bitlyGifUrl: String,
    @SerializedName( "bitly_url")
    val bitlyUrl: String,
    @SerializedName("embed_url")
    val embedUrl: String,
)