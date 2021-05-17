package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.learningboard.R
import kotlinx.android.synthetic.main.activity_alert_dialog.*

class AlertDialog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)

        btnAlert.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Alert Dialog")
            builder.setMessage("Are You sure you want to proceed the download?")
            builder.setIcon(R.drawable.ic_dialog_alert)
            builder.setPositiveButton("Yes"){dialogInterface, which->
                Toast.makeText(this,"clicked Yes",Toast.LENGTH_LONG).show()

            }


            builder.setNeutralButton("Cancel"){dialogInterface,which->
                Toast.makeText(this,"clicked Cancel",Toast.LENGTH_LONG).show()


            }


            builder.setNegativeButton("No"){dialogInterface,which->
                Toast.makeText(this,"clicked No",Toast.LENGTH_LONG).show()


            }

            val alertDialog = builder.create()
            alertDialog.setCancelable(true)
            alertDialog.show()
        }

    }
}