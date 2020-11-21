package com.example.exomindtest.data.entities


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "Users")
data class User(
    @PrimaryKey
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String?
)