package com.example.learningboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_radio__button.*

class Radio_Button : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio__button)

    radioGroup.setOnCheckedChangeListener { group, checkedId ->

        var rb = findViewById<RadioButton>(checkedId)
        if(rb!=null){
            restext.text = rb.text.toString()
        }
    }

       btnshow.setOnClickListener {
           var id = radioGroup.checkedRadioButtonId
           if (id != -1){
               val radiobtn = findViewById<RadioButton>(id)
               Toast.makeText(this,"On button click : ${radiobtn.text}",Toast.LENGTH_SHORT).show()
           }
           else{
               Toast.makeText(this,"On button click : nothing selected}",Toast.LENGTH_SHORT).show()
           }
       }

        btnclear.setOnClickListener {
            radioGroup.clearCheck()
            restext.text = "Select Option"
        }

    }
}