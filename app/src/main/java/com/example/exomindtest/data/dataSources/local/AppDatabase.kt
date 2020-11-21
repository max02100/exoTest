package com.example.exomindtest.data.dataSources.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.exomindtest.data.dataSources.local.daos.AlbumDao
import com.example.exomindtest.data.dataSources.local.daos.PhotoDao
import com.example.exomindtest.data.dataSources.local.daos.UserDao
import com.example.exomindtest.data.entities.Album
import com.example.exomindtest.data.entities.Photo
import com.example.exomindtest.data.entities.User

@Database(entities = [User::class, Album::class, Photo::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun photoDao(): PhotoDao
    abstract fun albumDao(): AlbumDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }

}