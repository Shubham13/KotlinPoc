package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import android.widget.ProgressBar
import android.widget.Toast
import com.example.learningboard.R
import kotlinx.android.synthetic.main.activity_progress_bar.*

class Progress_Bar : AppCompatActivity() {
    private var progressBar: ProgressBar? = null
    private var i = 0
    private var txtView: TextView? = null
    private val handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar)
        progressBar = findViewById<ProgressBar>(R.id.pbar) as ProgressBar
        showbutton.setOnClickListener {
            i = progressBar!!.progress
            Thread(Runnable {
                while(i<100){
                    i +=5
                    handler.post(Runnable {
                        progressBar!!.progress = i
//                        Toast.makeText(this@ProgressBar,progressBar!!.max,Toast.LENGTH_SHORT).show()
                        txtprogress!!.text = i.toString() + "/" + progressBar!!.max
                    })
                    try{
                        Thread.sleep(100)
                    }catch (e: InterruptedException){
                        e.printStackTrace()
                    }
                }
            }).start()

        }
    }
}