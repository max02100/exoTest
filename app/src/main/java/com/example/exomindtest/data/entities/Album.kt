package com.example.exomindtest.data.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class Album(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "title")
    val title: String,
    @field:Json(name = "userId")
    val userId: Int
)