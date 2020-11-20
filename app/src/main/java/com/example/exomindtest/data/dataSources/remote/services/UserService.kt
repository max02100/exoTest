package com.example.exomindtest.data.dataSources.remote.services

import com.example.exomindtest.data.entities.User
import retrofit2.http.GET

interface UserService {

    @GET("users")
    suspend fun getUser(): List<User>
}