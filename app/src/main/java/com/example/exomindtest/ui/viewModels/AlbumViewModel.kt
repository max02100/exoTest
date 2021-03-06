package com.example.exomindtest.ui.viewModels

import androidx.lifecycle.ViewModel
import com.example.exomindtest.data.repositories.Repository

class AlbumViewModel(private val repository: Repository) : ViewModel() {

    fun getAlbumsFromDB(id: Int) = repository.getAlbumsFromDB(id)
}