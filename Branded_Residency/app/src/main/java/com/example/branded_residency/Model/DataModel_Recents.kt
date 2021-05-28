package com.example.branded_residency.Model

import com.example.branded_residency.R

data class Recents(val imageResource:Int,val recentName:String)


object RecentData {
    val recent = listOf<Recents>(
        Recents(R.drawable.ic_baseline_person_outline_24,"Yoga"),
        Recents(R.drawable.ic_baseline_person_outline_24,"PetCare"),
        Recents(R.drawable.ic_baseline_person_outline_24,"Package"),
        Recents(R.drawable.ic_baseline_person_outline_24,"Entertainment")

    )

}

