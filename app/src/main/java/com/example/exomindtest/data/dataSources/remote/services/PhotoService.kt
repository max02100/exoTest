package com.example.exomindtest.data.dataSources.remote.services

import com.example.exomindtest.data.entities.Photo
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoService  {
    @GET("users/{userID}/photos")
    suspend fun getPhotos(@Query("userID") userId: Int): List<Photo>
}