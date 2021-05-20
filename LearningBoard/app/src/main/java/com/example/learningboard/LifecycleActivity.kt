package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.learningboard.R

class LifecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)



        Log.d("OnCreate Before Destroy","OK")
        Toast.makeText(this,"Activity 2 : OnCreate Called",Toast.LENGTH_SHORT).show()

    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"Activity 2 : OnStart Called", Toast.LENGTH_SHORT).show()
        Log.d("OnStart","Called")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"Activity 2 : OnResume Called", Toast.LENGTH_SHORT).show()
        Log.d("OnResume","called")
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this,"Activity 2 : onRestart Called", Toast.LENGTH_SHORT).show()

        Log.d("OnRestart","called")
    }


    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"Activity 2 : OnPause Called", Toast.LENGTH_SHORT).show()

        Log.d("OnPause","called")

    }

    override fun onStop() {
        super.onStop()
        Log.d("OnStop","Called")
        Toast.makeText(this,"Activity 2 : OnStop Called", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("OnDestroy","Called")
        Toast.makeText(this,"Activity 2 : OnDestroy Called", Toast.LENGTH_SHORT).show()

    }


}