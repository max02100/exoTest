package com.example.exomindtest.data.di

import com.example.exomindtest.data.dataSources.remote.AlbumRemoteDataSource
import com.example.exomindtest.data.dataSources.remote.PhotoRemoteDataSource
import com.example.exomindtest.data.dataSources.remote.UserRemoteDataSource
import com.example.exomindtest.data.dataSources.remote.services.AlbumService
import com.example.exomindtest.data.dataSources.remote.services.PhotoService
import com.example.exomindtest.data.dataSources.remote.services.UserService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApiModule  {
    val retrofitModule = module {
        single {
            Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .client(httpClient())
                .addConverterFactory(MoshiConverterFactory.create()).build()
        }
    }

    val servicesModule = module {
        fun provideUserApi(retrofit: Retrofit): UserService {
            return retrofit.create(UserService::class.java)
        }
        fun provideAlbumApi(retrofit: Retrofit): AlbumService {
            return retrofit.create(AlbumService::class.java)
        }
        fun providePhotoApi(retrofit: Retrofit): PhotoService {
            return retrofit.create(PhotoService::class.java)
        }
        single { provideUserApi(get()) }
        single { provideAlbumApi(get()) }
        single { providePhotoApi(get()) }
    }

    val apiDataSourcesModule = module {
        fun provideUserRemoteDataSource(service: UserService): UserRemoteDataSource {
            return UserRemoteDataSource(service)
        }
        fun provideAlbumRemoteDataSource(service: AlbumService): AlbumRemoteDataSource {
            return AlbumRemoteDataSource(service)
        }
        fun providePhotoRemoteDataSource(service: PhotoService): PhotoRemoteDataSource {
            return PhotoRemoteDataSource(service)
        }
        single { provideUserRemoteDataSource(get()) }
        single { provideAlbumRemoteDataSource(get()) }
        single { providePhotoRemoteDataSource(get()) }
    }

    private fun httpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
        val clientBuilder = OkHttpClient.Builder()
            .callTimeout(5, TimeUnit.MINUTES)
            .connectTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        clientBuilder.addInterceptor(httpLoggingInterceptor)
        return clientBuilder.build()
    }
}