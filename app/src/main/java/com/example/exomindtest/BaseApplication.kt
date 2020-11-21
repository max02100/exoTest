package com.example.exomindtest

import android.app.Application
import com.example.exomindtest.data.di.ApiModule
import com.example.exomindtest.data.di.DatabaseModule
import com.example.exomindtest.data.di.RepositoryModule
import com.example.exomindtest.data.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@BaseApplication)
            modules(
                listOf(
                    ViewModelModule.module,
                    RepositoryModule.module,
                    ApiModule.retrofitModule,
                    ApiModule.servicesModule,
                    ApiModule.apiDataSourcesModule,
                    DatabaseModule.module
                )
            )
            koin.createRootScope()
        }
    }
}