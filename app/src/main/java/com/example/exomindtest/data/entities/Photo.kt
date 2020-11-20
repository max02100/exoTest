package com.example.exomindtest.data.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class Photo(
    @field:Json(name = "albumId")
    val albumId: Int?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "thumbnailUrl")
    val thumbnailUrl: String?,
    @field:Json(name = "title")
    val title: String?,
    @field:Json(name = "url")
    val url: String?
)