package com.example.exomindtest.data.dataSources.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.exomindtest.data.entities.Album
import com.example.exomindtest.data.entities.User

@Dao
interface AlbumDao {

    @Query("SELECT * FROM Albums ORDER BY title ASC")
    fun getAll(): LiveData<List<Album>>

    @Query("SELECT * FROM Albums WHERE userId = :userId ORDER BY title ASC")
    fun getAlbumsByUserId(userId: Int): LiveData<List<Album>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(users: List<Album>)
}