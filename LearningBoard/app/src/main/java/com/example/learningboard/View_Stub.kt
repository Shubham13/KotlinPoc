package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewStub
import com.example.learningboard.R


import kotlinx.android.synthetic.main.activity_view_stub.*

class View_Stub : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_stub)


        var view_stub = findViewById<View>(R.id.viewStub) as ViewStub

        view_stub!!.inflate()

        btnShow!!.setOnClickListener {
            view_stub!!.visibility = View.VISIBLE
        }

        btnHide!!.setOnClickListener {
            view_stub!!.visibility = View.GONE
        }
    }
}