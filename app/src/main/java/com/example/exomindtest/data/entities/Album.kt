package com.example.exomindtest.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "Albums")
data class Album(
    @PrimaryKey
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "title")
    val title: String,
    @field:Json(name = "userId")
    val userId: Int
)