package com.example.exomindtest.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exomindtest.R
import com.example.exomindtest.data.entities.User

class UserAdapter(val goToPhotosclickListener: (Int) -> Unit, val goToAlbumsclickListener: (Int) -> Unit) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var users: List<User> = listOf()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.userNameTextView)
        val goToPhotosButton: Button = view.findViewById(R.id.goToPhotosButton)
        val goToAlbumsButton: Button = view.findViewById(R.id.goToAlbumsButton)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_user, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.apply {
            textView.text = users[position].name
            goToPhotosButton.setOnClickListener {
                goToPhotosclickListener(users[position].id)
            }
            goToAlbumsButton.setOnClickListener {
                goToAlbumsclickListener(users[position].id)
            }
        }
    }

    override fun getItemCount() = users.size

    fun setData(list: List<User>) {
        users = list
        notifyDataSetChanged()
    }
}