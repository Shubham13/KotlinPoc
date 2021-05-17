package com.example.learningboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication.LifecycleActivity
import kotlinx.android.synthetic.main.activity_life_cycle1.*

class LifeCycleActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle1)

        Log.d("OnCreate Before Destroy", "OK")
        Toast.makeText(this, "Activity 1 : OnCreate Called", Toast.LENGTH_SHORT).show()


        btnActivity.setOnClickListener {
            val intent = Intent(this, LifecycleActivity::class.java)
            startActivity(intent)

        }
    }



    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"Activity 1 : OnStart Called",Toast.LENGTH_SHORT).show()
        Log.d("OnStart","Called")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"Activity 1 : OnResume Called",Toast.LENGTH_SHORT).show()
        Log.d("OnResume","called")
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this,"Activity 1 : onRestart Called",Toast.LENGTH_SHORT).show()

        Log.d("OnRestart","called")
    }


    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"Activity 1 : OnPause Called",Toast.LENGTH_SHORT).show()

        Log.d("OnPause","called")

    }

    override fun onStop() {
        super.onStop()
        Log.d("OnStop","Called")
        Toast.makeText(this,"Activity 1 : OnStop Called",Toast.LENGTH_SHORT).show()

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("OnDestroy","Called")
        Toast.makeText(this,"Activity 1 : OnDestroy Called",Toast.LENGTH_SHORT).show()

    }

}