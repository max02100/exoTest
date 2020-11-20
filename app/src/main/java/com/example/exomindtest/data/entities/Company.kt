package com.example.exomindtest.data.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class Company(
    @field:Json(name = "bs")
    val bs: String?,
    @field:Json(name = "catchPhrase")
    val catchPhrase: String?,
    @field:Json(name = "name")
    val name: String?
)