package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.learningboard.R
import kotlinx.android.synthetic.main.activity_date_picker.*
import java.util.*

class DatePicker : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)

        val today = Calendar.getInstance()
        date_picker.init(today.get(Calendar.YEAR),today.get(Calendar.MONTH),today.get(Calendar.DAY_OF_MONTH)){
            view,year,month , day ->
            val msg = "You Selected: $day/$month/$year"
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        }
        datePicker1.init(today.get(Calendar.YEAR),today.get(Calendar.MONTH),today.get(Calendar.DAY_OF_MONTH)){
                view,year,month , day ->
            val msg = "You Selected: $day/$month/$year"
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        }


    }
}