package com.example.branded_residency.Model

import com.example.branded_residency.Favorites
import com.example.branded_residency.R

data class CategoryList(val imgResource : Int,val name:String)


object CatListData {
    val category = listOf<CategoryList>(
        CategoryList(R.drawable.salon, "salon"),
        CategoryList(R.drawable.salon, "Salon"),
        CategoryList(R.drawable.salon, "salon"),
        CategoryList(R.drawable.salon, "salon")

    )
}