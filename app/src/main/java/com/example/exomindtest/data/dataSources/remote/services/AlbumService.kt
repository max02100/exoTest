package com.example.exomindtest.data.dataSources.remote.services

import com.example.exomindtest.data.entities.Album
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AlbumService {

    @GET("users/{userID}/albums")
    suspend fun getAlbumByUserId(@Path("userID") userId: Int): List<Album>
}