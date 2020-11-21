package com.example.exomindtest.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.exomindtest.R
import com.example.exomindtest.data.entities.Photo
import com.squareup.picasso.Picasso

class PhotoAdapter(private val photos: List<Photo>, val clickListener: (String) -> Unit) :
    RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    private lateinit var context: Context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        context = viewGroup.context
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_photo, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val photo = photos[position]
        Picasso.get().load(photo.url).into(viewHolder.imageView)
        viewHolder.itemView.setOnClickListener { clickListener(photo.url) }
    }

    override fun getItemCount() = photos.size
}