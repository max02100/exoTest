package com.example.exomindtest.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.exomindtest.R
import com.example.exomindtest.data.entities.ApiResource
import com.example.exomindtest.ui.viewModels.PhotoViewModel
import kotlinx.android.synthetic.main.activity_albums.*
import kotlinx.android.synthetic.main.activity_photos.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhotosActivity : AppCompatActivity() {

    val viewModel by viewModel<PhotoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)

        intent.extras?.let { extras ->
            if (extras.containsKey("id")) {
                extras.getInt("id").let {
                    viewModel.getPhotos(it).observe(this, { data ->
                        if (data.status == ApiResource.Status.SUCCESS) {
                            Glide.with(this).load(data.data!!.first().url).into(imageView)
                            albumsRecyclerView.apply {
                                setHasFixedSize(true)
                                data.data.let {

                                }
                            }
                        }
                    })
                }
            }
        }
    }
}