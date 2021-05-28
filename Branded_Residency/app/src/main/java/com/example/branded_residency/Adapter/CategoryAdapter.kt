package com.example.branded_residency.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.branded_residency.Category
import com.example.branded_residency.R
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter( val categories: List<Category>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){
    var row_index = -1

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val linearLayout : LinearLayout = itemView.findViewById(R.id.linearLayout)
        fun setData(category: Category?, position:Int){
                itemView.category_name.text = category?.categoryName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
        return CategoryViewHolder(view)

    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.setData(category,position)
        holder.linearLayout.setOnClickListener {
                row_index = position
                notifyDataSetChanged()
        }

        if(row_index == position) {
            holder.linearLayout.setBackgroundResource(R.drawable.item_selected)

        }
        else{
            holder.linearLayout.setBackgroundResource(R.drawable.circular_shape)

        }
    }

    override fun getItemCount(): Int {
      return categories.size
    }
}