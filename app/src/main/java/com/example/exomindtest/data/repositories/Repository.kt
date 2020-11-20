package com.example.exomindtest.data.repositories

import com.example.exomindtest.data.dataSources.remote.AlbumRemoteDataSource
import com.example.exomindtest.data.dataSources.remote.PhotoRemoteDataSource
import com.example.exomindtest.data.dataSources.remote.UserRemoteDataSource
import com.example.exomindtest.data.dataSources.remote.performGetOperation

class Repository(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val albumRemoteDataSource: AlbumRemoteDataSource,
    private val photoRemoteDataSource: PhotoRemoteDataSource
) {

    fun getUsers() = performGetOperation(
        networkCall = { userRemoteDataSource.getUsers() }
    )

    fun getAlbums(id: Int) = performGetOperation(
        networkCall = { albumRemoteDataSource.getAlbums(id) }
    )

    fun getPhotos(id: Int) = performGetOperation(
        networkCall = { photoRemoteDataSource.getPhotos(id) }
    )
}