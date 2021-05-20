package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.Toast
import com.example.learningboard.R
import kotlinx.android.synthetic.main.activity_rating_bar.*

class RatingBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating_bar)

        val rBar = RatingBar(this)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
             rBar.stepSize = 1.0.toFloat()
             rBar.numStars = 5

        constaint?.addView(rBar)



        button.setOnClickListener {
            val rating  = ratingBar.rating.toString()
            Toast.makeText(this,"Rating is: ${rating}",Toast.LENGTH_SHORT).show()
            Toast.makeText(this,"Rating is: ${rBar.rating.toString()}",Toast.LENGTH_SHORT).show()

        }
    }
}