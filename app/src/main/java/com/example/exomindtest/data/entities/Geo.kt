package com.example.exomindtest.data.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class Geo(
    @field:Json(name = "lat")
    val lat: String?,
    @field:Json(name = "lng")
    val lng: String?
)