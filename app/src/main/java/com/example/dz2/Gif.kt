package com.example.dz2

import com.google.gson.annotations.SerializedName



data class Gif(
    @field:SerializedName("url")
    val url: String,
    @field:SerializedName("slug")
    val slug: String,
    @field:SerializedName( "bitly_gif_url")
    val bitlyGifUrl: String,
    @field:SerializedName("bitly_url")
    val bitlyUrl: String,
    @field:SerializedName("embed_url")
    val embedUrl: String,
)