package com.example.exomindtest.data.di

import com.example.exomindtest.ui.viewModels.AlbumViewModel
import com.example.exomindtest.ui.viewModels.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {
    val module = module {
        viewModel { UserViewModel(get()) }
        viewModel { AlbumViewModel(get()) }
    }

}