package com.example.exomindtest.data.di

import com.example.exomindtest.data.dataSources.local.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object DatabaseModule {
    val module = module {
        single { AppDatabase.getDatabase(androidContext()) }
    }
}