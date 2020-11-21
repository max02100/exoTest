package com.example.exomindtest.data.dataSources.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.exomindtest.data.entities.Album
import com.example.exomindtest.data.entities.Photo
import com.example.exomindtest.data.entities.User

@Dao
interface PhotoDao {

    @Query("SELECT * FROM Photos ORDER BY id ASC")
    fun getAll(): LiveData<List<Photo>>

    @Query("SELECT * FROM Photos WHERE userId = :userId ORDER BY id ASC")
    fun getPhotosByUserId(userId: Int): LiveData<List<Photo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(photos: List<Photo>)
}