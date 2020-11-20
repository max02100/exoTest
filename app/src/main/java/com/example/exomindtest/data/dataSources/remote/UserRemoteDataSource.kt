package com.example.exomindtest.data.dataSources.remote

import com.example.exomindtest.data.dataSources.remote.services.UserService

class UserRemoteDataSource(private val userService: UserService): BaseDataSource() {

    suspend fun getUsers() = getResult { userService.getUser() }

}