package com.example.exomindtest.data.repositories

import com.example.exomindtest.data.dataSources.local.AppDatabase
import com.example.exomindtest.data.dataSources.remote.AlbumRemoteDataSource
import com.example.exomindtest.data.dataSources.remote.PhotoRemoteDataSource
import com.example.exomindtest.data.dataSources.remote.UserRemoteDataSource
import com.example.exomindtest.data.dataSources.remote.performGetOperation

class Repository(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val albumRemoteDataSource: AlbumRemoteDataSource,
    private val photoRemoteDataSource: PhotoRemoteDataSource,
    private val database: AppDatabase
) {

    fun getUsers() = performGetOperation(
        networkCall = { userRemoteDataSource.getUsers() },
        saveCallResult = {
            it?.let {
                database.userDao().insertAll(it)
            }
        }
    )

    fun getAlbums(id: Int) = performGetOperation(
        networkCall = { albumRemoteDataSource.getAlbums(id) },
        saveCallResult = {
            it?.let {
                database.albumDao().insertAll(it)
            }
        }
    )

    fun getPhotos(userId: Int) = performGetOperation(
        networkCall = { photoRemoteDataSource.getPhotos(userId) },
        saveCallResult = {
            it?.let {
                it.forEachIndexed { index, element ->
                    element.id = "${userId}$index"
                    element.userId = userId
                }
                database.photoDao().insertAll(it)
            }
        }
    )

    fun getUsersFromDB() = database.userDao().getAll()
    fun getAlbumsFromDB(userId: Int) = database.albumDao().getAlbumsByUserId(userId)
    fun getPhotosFromDB(userId: Int) = database.photoDao().getPhotosByUserId(userId)
}