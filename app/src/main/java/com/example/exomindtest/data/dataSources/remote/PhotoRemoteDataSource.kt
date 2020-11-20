package com.example.exomindtest.data.dataSources.remote

import com.example.exomindtest.data.dataSources.remote.services.PhotoService

class PhotoRemoteDataSource(private val userService: PhotoService): BaseDataSource() {

    suspend fun getPhotos(id: Int) = getResult { userService.getPhotos(id) }

}