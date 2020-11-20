package com.example.exomindtest.data.di
import com.example.exomindtest.data.repositories.Repository
import org.koin.dsl.module

object RepositoryModule {
    val module = module {
        single { Repository(get(), get(), get()) }
    }
}