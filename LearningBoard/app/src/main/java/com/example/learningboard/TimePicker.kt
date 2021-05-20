package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learningboard.R
import kotlinx.android.synthetic.main.activity_auto_complete_text_view.*
import kotlinx.android.synthetic.main.activity_time_picker.*

class TimePicker : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker)
        timepicker.setOnTimeChangedListener { _, hourOfDay, minute -> var hour = hourOfDay

            var am_pm = ""
            when{hour == 0 ->{ hour += 12
                am_pm = "AM"


            }

            hour == 12 -> am_pm = "PM"
                hour > 12 ->{
                    hour -= 12
                    am_pm = "PM"
                }
                else -> am_pm = "AM"
            }

            val hour1 = if (hour< 10) "0" + hour else hour
            val min = if(minute < 10) "0" + minute else minute

            val msg = "Time is: $hour : $min $am_pm"
            txttime.text = msg

        }

        timepicker1.setOnTimeChangedListener { _, hourOfDay, minute -> var hour = hourOfDay

            var am_pm = ""
            when{hour == 0 ->{ hour += 12
                am_pm = "AM"


            }

                hour == 12 -> am_pm = "PM"
                hour > 12 ->{
                    hour -= 12
                    am_pm = "PM"
                }
                else -> am_pm = "AM"
            }

            val hour1 = if (hour< 10) "0" + hour else hour
            val min = if(minute < 10) "0" + minute else minute

            val msg = "Time is: $hour : $min $am_pm"
            txttime.text = msg

        }

        }}



