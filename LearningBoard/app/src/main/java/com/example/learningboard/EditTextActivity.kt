package com.example.learningboard

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_text.*

class EditTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text)


        edttxt.setOnClickListener {
            val phn = edttxt.text.toString()

            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phn" ))
            startActivity(intent)
        }
    }
}