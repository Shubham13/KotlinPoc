package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.learningboard.R
import kotlinx.android.synthetic.main.activity_search_view.*

class SearchView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_view)

        var planets: List<String> = listOf<String>("Venus","Pluto","Neptune","Jupiter","Mercury","Earth","Sun","Mars","Saturn","Venus1","Pluto1","Neptune1","Jupiter1","Mercury1","Earth1","Sun1","Mars1","Saturn1")

        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,planets)
        lstView.adapter = adapter

        srchView.setOnQueryTextListener(object:
            SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if(planets.contains(query))
                    adapter.filter.filter(query)
                else
                    Toast.makeText(this@SearchView, "No Match found",Toast.LENGTH_LONG).show();
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {


                adapter.filter.filter(newText)
                return false
            }
        }

        )

    }
}