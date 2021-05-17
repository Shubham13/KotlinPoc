package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.learningboard.R
import kotlinx.android.synthetic.main.activity_image_switcher.*

class ImageSwitcher : AppCompatActivity() {
    private val planets = intArrayOf(R.drawable.jupiter,R.drawable.mars,R.drawable.mercury,R.drawable.venus,R.drawable.pluto,R.drawable.saturn)
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_switcher)

        imgswitch?.setFactory({
            val imgView = ImageView(this)
            imgView.scaleType = ImageView.ScaleType.FIT_CENTER
            imgView.setPadding(8,8,8,8)
            imgView
        })

        imgswitch?.setImageResource(planets[index])

        val imgIn = AnimationUtils.loadAnimation(
            this,android.R.anim.slide_in_left
        )
        imgswitch?.inAnimation = imgIn
        val imgOut = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right)
        imgswitch?.outAnimation = imgOut

        prev.setOnClickListener {
            index = if(index - 1>= 0 ) index - 1 else 2
            imgswitch?.setImageResource(planets[index])

        }
        next.setOnClickListener {

            index = if(index + 1 < planets.size ) index + 1 else 0
            imgswitch?.setImageResource(planets[index])
        }



    }
}