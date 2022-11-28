package com.example.dz2.model

import com.google.gson.annotations.SerializedName

data class PaginationData (
    @SerializedName( "total_count")
    val totalCount: Int,
    @SerializedName( "count")
    val count: Int,
    @SerializedName( "offset")
    val offset: Int,
)