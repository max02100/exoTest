package com.example.exomindtest.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exomindtest.R
import com.example.exomindtest.data.entities.ApiResource
import com.example.exomindtest.ui.adapters.AlbumAdapter
import com.example.exomindtest.ui.viewModels.AlbumViewModel
import kotlinx.android.synthetic.main.activity_albums.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AlbumsActivity : AppCompatActivity() {

    private val viewModel: AlbumViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)

        intent.extras?.let { extras ->
            if (extras.containsKey("id")) {
                extras.getInt("id").let {
                    viewModel.getAlbumsFromDB(it).observe(this, { data ->
                        albumsRecyclerView.apply {
                            setHasFixedSize(true)
                            data?.let {
                                adapter = AlbumAdapter(it) { id: Int ->
                                    run {
                                        val intent = Intent(
                                            this@AlbumsActivity,
                                            PhotosActivity::class.java
                                        ).apply {
                                            putExtra("id", id)
                                        }
                                        this@AlbumsActivity.startActivity(intent)
                                    }
                                }
                            }
                        }
                    })
                }
            }
        }
    }
}