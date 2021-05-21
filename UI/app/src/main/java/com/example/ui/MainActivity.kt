package com.example.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        imgedt.setOnClickListener {
            val bottomFragment = ImageEditDialogFragment()
            bottomFragment.show(supportFragmentManager, "bottom_sheet")
        }

        btnName1.setOnClickListener {
            val bottomFragment = ActionBottomDialogFragment()
            bottomFragment.show(supportFragmentManager, "bottom_sheet")


        }
    }
}