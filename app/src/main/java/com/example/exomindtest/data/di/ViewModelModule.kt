package com.example.exomindtest.data.di

import com.example.exomindtest.ui.viewModels.AlbumViewModel
import com.example.exomindtest.ui.viewModels.PhotoViewModel
import com.example.exomindtest.ui.viewModels.SplashViewModel
import com.example.exomindtest.ui.viewModels.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {
    val module = module {
        viewModel { SplashViewModel(get()) }
        viewModel { UserViewModel(get()) }
        viewModel { AlbumViewModel(get()) }
        viewModel { PhotoViewModel(get()) }
    }

}