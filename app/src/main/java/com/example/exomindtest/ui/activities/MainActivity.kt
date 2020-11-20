package com.example.exomindtest.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.example.exomindtest.R
import com.example.exomindtest.data.entities.User
import com.example.exomindtest.ui.adapters.UserAdapter
import com.example.exomindtest.ui.viewModels.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModel()

    private val mUsers = mutableListOf<User>()
    private val mAdapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usersRecyclerView.apply {
            setHasFixedSize(true)
            adapter = mAdapter
        }

        viewModel.getUsers().observe(this, {
            it.data?.let { usersFromApi ->
                mUsers.addAll(usersFromApi)
                mAdapter.setData(mUsers)
            }
        })

        searchEditText.doOnTextChanged { text, _, _, count ->
            if (count > 0) {
                mAdapter.setData(mUsers)
            } else {
                val foundUsers = mUsers.filter {
                    it.name?.let { name ->
                        text?.let { textToSearch ->
                            name.contains(textToSearch)
                        }
                    } ?: false
                }
                mAdapter.setData(foundUsers)
            }
        }
    }
}