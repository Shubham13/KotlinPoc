package com.example.learningboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnRecyclerViewDemo.setOnClickListener {
            val intent = Intent(this,ContextMenu::class.java)
            startActivity(intent)
        }

        btnTextView.setOnClickListener {
            val intent= Intent(this,TextView::class.java)
            startActivity(intent)
        }

        btnButton.setOnClickListener {
            val intent = Intent(this,EditTextActivity::class.java)
            startActivity(intent)
        }

        toggleButton.setOnClickListener{
            var str = ""
            str = toggleButton.text.toString()
            Toast.makeText(this,"Toggle Button 1 : $str",Toast.LENGTH_SHORT).show()

        }

        toggleButton1.setOnClickListener{
            var str = ""
            str = toggleButton1.text.toString()

            Toast.makeText(this,"Toggle Button 2 : $str",Toast.LENGTH_SHORT).show()

        }

        register.setOnClickListener {

            var result = "Registered Courses :"

          if(checkbox.isChecked){
              result = result + "\n${checkbox.text.toString()}"
          }
            if(checkbox1.isChecked){
                result = result + "\n${checkbox1.text.toString()}"
            }
            if(checkbox2.isChecked){
                result = result + "\n${checkbox2.text.toString()}"
            }
            if(checkbox3.isChecked){
                result = result + "\n${checkbox3.text.toString()}"
            }

            Toast.makeText(this,"$result",Toast.LENGTH_SHORT).show()
        }

button2.setOnClickListener {
    val intent = Intent(this,Radio_Button::class.java)
    startActivity(intent)
}

        btnlifecycle.setOnClickListener {
            val intent = Intent(this,LifeCycleActivity1::class.java)
            startActivity(intent)
        }

    }
}