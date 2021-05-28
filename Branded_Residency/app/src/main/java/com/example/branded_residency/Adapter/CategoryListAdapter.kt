package com.example.branded_residency.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.branded_residency.Category
import com.example.branded_residency.Model.CategoryList
import com.example.branded_residency.R
import kotlinx.android.synthetic.main.item_category.view.*
import kotlinx.android.synthetic.main.item_category_list.view.*

class CategoryListAdapter( val categories: List<CategoryList>) : RecyclerView.Adapter<CategoryListAdapter.CategoryListViewHolder>(){
    inner class CategoryListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

            val imageView : ImageView = itemView.cat_icon
            val name = itemView.cat_name


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category_list,parent,false)
        return CategoryListViewHolder(view)

    }

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {

        val category = categories[position]
        holder.imageView.setImageResource(category.imgResource)
        holder.name.text = category.name
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}