package com.example.exomindtest.ui.viewModels

import androidx.lifecycle.ViewModel
import com.example.exomindtest.data.repositories.Repository

class PhotoViewModel(private val repository: Repository): ViewModel() {

    fun getPhotosFromDB(id: Int) = repository.getPhotosFromDB(id)
}