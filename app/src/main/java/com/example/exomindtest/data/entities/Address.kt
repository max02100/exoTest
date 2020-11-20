package com.example.exomindtest.data.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class Address(
    @field:Json(name = "city")
    val city: String?,
    @field:Json(name = "geo")
    val geo: Geo?,
    @field:Json(name = "street")
    val street: String?,
    @field:Json(name = "suite")
    val suite: String?,
    @field:Json(name = "zipcode")
    val zipcode: String?
)