package com.example.branded_residency.Adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.branded_residency.Fragment.CategoryFragment


class ViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {


    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                return CategoryFragment()

            }
            1 -> {
                return CategoryFragment()
            }

            2 -> {
                return CategoryFragment()
            }
            else -> return CategoryFragment()
        }
    }


}