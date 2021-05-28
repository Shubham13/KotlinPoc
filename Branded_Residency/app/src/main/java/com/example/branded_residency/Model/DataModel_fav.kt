package com.example.branded_residency



data class Favorites(val imageResource:Int,val favName:String)


object FavData {
    val fav = listOf<Favorites>(
        Favorites(R.drawable.ic_baseline_person_outline_24,"Visitor"),
        Favorites(R.drawable.ic_baseline_person_outline_24,"Tennis"),
        Favorites(R.drawable.ic_baseline_person_outline_24,"Package"),
        Favorites(R.drawable.ic_baseline_person_outline_24,"Entertainment")

    )

}
