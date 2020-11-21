package com.example.exomindtest.data.entities


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "Photos")
data class Photo(
    @PrimaryKey
    var id: String,
    var userId: Int,
    @field:Json(name = "thumbnailUrl")
    val thumbnailUrl: String,
    @field:Json(name = "url")
    val url: String
)