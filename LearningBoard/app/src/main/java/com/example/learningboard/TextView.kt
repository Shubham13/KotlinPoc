package com.example.learningboard

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_textview.*

class TextView : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState )
        setContentView(R.layout.activity_textview)


        Toast.makeText(this,"Welcome to Learning Board",Toast.LENGTH_SHORT)
        textView2.setOnClickListener {
            textView2.setText("Welcome to LearningBoard!!")
            Toast.makeText(this,"Welcome to Learning Board",Toast.LENGTH_SHORT)
        }

        // Using Html TextView

        val s = "This is <i>italic</i> <b>bold</b> <u>underlined</u> <br>Goto <a href='https://www.google.com'> LearningBoard </a>"

        text.movementMethod = LinkMovementMethod.getInstance()
        text.text = Html.fromHtml(s, Html.FROM_HTML_MODE_COMPACT)
    }
}
