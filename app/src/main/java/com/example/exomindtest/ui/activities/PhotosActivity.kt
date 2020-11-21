package com.example.exomindtest.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.exomindtest.R
import com.example.exomindtest.ui.adapters.PhotoAdapter
import com.example.exomindtest.ui.viewModels.PhotoViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_photos.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhotosActivity : AppCompatActivity() {

    private val viewModel by viewModel<PhotoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)

        intent.extras?.let { extras ->
            if (extras.containsKey("id")) {
                extras.getInt("id").let {
                    viewModel.getPhotosFromDB(it).observe(this, { data ->
                        photosRecyclerView.apply {
                            setHasFixedSize(true)
                            data?.let { list ->
                                Picasso.get().load(list.first().url).into(imageView)
                                adapter = PhotoAdapter(list) { url ->
                                    Picasso.get().load(url).into(imageView)
                                }
                            }
                        }
                    })
                }
            }
        }
    }
}