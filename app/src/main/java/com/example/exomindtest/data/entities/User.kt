package com.example.exomindtest.data.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class User(
    @field:Json(name = "address")
    val address: Address?,
    @field:Json(name = "company")
    val company: Company?,
    @field:Json(name = "email")
    val email: String?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "phone")
    val phone: String?,
    @field:Json(name = "username")
    val username: String?,
    @field:Json(name = "website")
    val website: String?
)