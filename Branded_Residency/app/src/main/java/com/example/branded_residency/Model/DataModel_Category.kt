package com.example.branded_residency

data class Category(val categoryName:String)


object CatData{
    val category = listOf<Category>(
        Category("All"),
        Category("Health & Wellness"),
        Category("Fitness"),
        Category("Entertainment"),
        Category("Interest"),
        Category("Salon")
    )
}