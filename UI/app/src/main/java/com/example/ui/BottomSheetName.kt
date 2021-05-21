package com.example.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class BottomSheetName : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottomsheet_name)
        supportActionBar?.hide()

    }
}