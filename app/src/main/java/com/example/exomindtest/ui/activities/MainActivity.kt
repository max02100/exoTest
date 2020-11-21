package com.example.exomindtest.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.example.exomindtest.R
import com.example.exomindtest.data.entities.ApiResource
import com.example.exomindtest.data.entities.User
import com.example.exomindtest.ui.adapters.UserAdapter
import com.example.exomindtest.ui.viewModels.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class MainActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModel()

    private val mUsers = mutableListOf<User>()
    private lateinit var mAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = UserAdapter(goToAlbumsclickListener = {
            val intent = Intent(this, AlbumsActivity::class.java).apply {
                putExtra("id", it)
            }
            this.startActivity(intent)
        }, goToPhotosclickListener = {
            val intent = Intent(this, PhotosActivity::class.java).apply {
                putExtra("id", it)
            }
            this.startActivity(intent)
        })

        usersRecyclerView.apply {
            setHasFixedSize(true)
            adapter = mAdapter
        }

        viewModel.getUsers().observe(this, {
            mUsers.addAll(it)
            mAdapter.setData(mUsers)
        })

        searchEditText.doAfterTextChanged {
            it?.let {
                if (it.isEmpty() || it.isBlank()) {
                    mAdapter.setData(mUsers)
                } else {
                    val foundUsers = mUsers.filter { user ->
                        user.name?.let { name ->
                            it.let { textToSearch ->
                                name.toLowerCase(Locale.getDefault())
                                    .contains(
                                        textToSearch.toString().toLowerCase(Locale.getDefault())
                                    )
                            }
                        } ?: false
                    }
                    mAdapter.setData(foundUsers)
                }
            }
        }
    }
}