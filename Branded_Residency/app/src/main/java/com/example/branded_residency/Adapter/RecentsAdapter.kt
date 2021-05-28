package com.example.branded_residency.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.branded_residency.Favorites
import com.example.branded_residency.Model.Recents
import com.example.branded_residency.R
import kotlinx.android.synthetic.main.item_favorite.view.*
import kotlinx.android.synthetic.main.item_recent.view.*

class RecentsAdapter(private val recentsList : List<Recents>) : RecyclerView.Adapter<RecentsAdapter.RecentsViewHolder>(){
    inner class RecentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.recents_icon
        val recentsName = itemView.recents_name

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recent,parent,false)

        return RecentsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecentsViewHolder, position: Int) {
        val currentItem = recentsList[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.recentsName.text = currentItem.recentName
    }

    override fun getItemCount(): Int {
        return recentsList.size
    }
}