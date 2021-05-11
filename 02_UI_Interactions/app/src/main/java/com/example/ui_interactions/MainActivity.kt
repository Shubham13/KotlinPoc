package com.example.ui_interactions

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener {

//            val var1 = try {
//                etVar1.text.toString().toInt()
//            } catch (e: NumberFormatException) {
//                0
//            }
//            val var2 = try {
//                etVar2.text.toString().toInt()
//            } catch (e: NumberFormatException) {
//                0
//            }
//            val result = (var1 + var2).toString()
//            tvResult.text = result

        val Var1 : Int
        val Var2 : Int
        try{
            Var1 = etVar1.text.toString().toInt()
            Var2 = etVar2.text.toString().toInt()
        }
        catch (e: NumberFormatException){
            AlertDialog.Builder(this)
                .setTitle("Invalid Operation")
                .setMessage("Please Enter both numbers to calculate")
                .setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })
                .setCancelable(false)
                .show()
            return@setOnClickListener
        }
            val result = Var1 + Var2
        }

//        findViewById<EditText>(R.id.etVar1).text
    }
}