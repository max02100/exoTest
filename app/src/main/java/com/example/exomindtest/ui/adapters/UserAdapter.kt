package com.example.exomindtest.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exomindtest.data.entities.User

class UserAdapter :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var users: List<User> = listOf()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(android.R.layout.simple_list_item_1, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = users[position].name
    }

    override fun getItemCount() = users.size

    fun setData(list: List<User>) {
        users = list
        notifyDataSetChanged()
    }
}