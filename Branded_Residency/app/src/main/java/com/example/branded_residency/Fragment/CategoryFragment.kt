package com.example.branded_residency.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.branded_residency.Adapter.CategoryAdapter
import com.example.branded_residency.Adapter.CategoryListAdapter
import com.example.branded_residency.CatData
import com.example.branded_residency.Model.CatListData
import com.example.branded_residency.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_category.*


class CategoryFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categorylist_adapter = CategoryListAdapter(CatListData.category)
        Category_List.adapter = categorylist_adapter
    }

            }

