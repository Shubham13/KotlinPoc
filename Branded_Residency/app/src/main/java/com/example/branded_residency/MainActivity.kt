package com.example.branded_residency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.branded_residency.Adapter.*
import com.example.branded_residency.Model.CatListData
import com.example.branded_residency.Model.RecentData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_category.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val viewpager_adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)
        viewPager.adapter = viewpager_adapter



        val categories_adapter = CategoryAdapter(CatData.category)
        categoryRecycler.adapter = categories_adapter




        val favorites_adapter = FavoritesAdapter(FavData.fav)
        favoritesRecyclerView.adapter = favorites_adapter

        val recents_adapter = RecentsAdapter(RecentData.recent)
        recentRecyclerView.adapter = recents_adapter


    }
}