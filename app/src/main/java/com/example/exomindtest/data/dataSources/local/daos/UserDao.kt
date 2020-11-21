package com.example.exomindtest.data.dataSources.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.exomindtest.data.entities.User

@Dao
interface UserDao {

    @Query("SELECT * FROM Users ORDER BY name ASC")
    fun getAll(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(users: List<User>)
}