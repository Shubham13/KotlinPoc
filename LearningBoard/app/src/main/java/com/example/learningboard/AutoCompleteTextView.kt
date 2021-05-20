package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.learningboard.R
import kotlinx.android.synthetic.main.activity_auto_complete_text_view.*

class AutoCompleteTextView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_complete_text_view)


        val adapter = ArrayAdapter.createFromResource(this,R.array.planets_array,android.R.layout.simple_list_item_1)
        autoTextView.setAdapter(adapter)


    }
}