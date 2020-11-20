package com.example.exomindtest.data.dataSources.remote

import com.example.exomindtest.data.dataSources.remote.services.AlbumService

class AlbumRemoteDataSource(private val albumService: AlbumService) : BaseDataSource() {
    suspend fun getAlbums(id: Int) = getResult { albumService.getAlbumByUserId(id) }
}