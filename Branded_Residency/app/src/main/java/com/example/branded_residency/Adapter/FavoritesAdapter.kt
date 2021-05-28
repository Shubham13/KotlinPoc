package com.example.branded_residency.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.branded_residency.Favorites
import com.example.branded_residency.R
import kotlinx.android.synthetic.main.item_favorite.view.*

class FavoritesAdapter(private val favList : List<Favorites>) :RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>(){
    inner class FavoritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.fav_icon
        val favoriteName = itemView.fav_name

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite,parent,false)

            return FavoritesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
            val currentItem = favList[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.favoriteName.text = currentItem.favName
    }

    override fun getItemCount(): Int {
        return favList.size
    }
}