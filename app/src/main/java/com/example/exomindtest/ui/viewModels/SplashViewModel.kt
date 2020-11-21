package com.example.exomindtest.ui.viewModels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.exomindtest.data.entities.ApiResource
import com.example.exomindtest.data.entities.Photo
import com.example.exomindtest.data.repositories.Repository

class SplashViewModel(private val repository: Repository) : ViewModel() {

    fun initRoom() = MediatorLiveData<Boolean>().apply {
        var albumsAreOk = 0
        var photosAreOk = 0
        var usersCount = 0
        val photosToSave = mutableListOf<Photo>()
        addSource(repository.getUsers()) {
            if (it.status == ApiResource.Status.SUCCESS) {
                it.data?.let {
                    usersCount = it.size
                    it.forEach { user ->
                        addSource(repository.getAlbums(user.id)) {
                            if (it.status == ApiResource.Status.SUCCESS) {
                                albumsAreOk += 1
                                if (albumsAreOk == usersCount && photosAreOk == usersCount)
                                    value = true
                            }
                        }
                        addSource(repository.getPhotos(user.id)) {
                            if (it.status == ApiResource.Status.SUCCESS) {
                                /*it.data?.forEach {
                                    val photo = it
                                    photo.userId = user.id
                                    photosToSave.add(photo)
                                }*/
                                photosAreOk += 1
                                if (albumsAreOk == usersCount && photosAreOk == usersCount)
                                    value = true
                            }
                        }
                    }
                }
            }
        }
    }


}