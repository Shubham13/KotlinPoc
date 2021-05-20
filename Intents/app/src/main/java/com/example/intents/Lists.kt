package com.example.intents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_lists.*
import kotlinx.android.synthetic.main.list_item_course.view.*

class Lists : AppCompatActivity() {

// 1. Simple List

    //    private val courses = listOf(
//        "Android","NodeJS","Django","Competitive Programming","C","C++","Data Structure","ReactJs",
//        "Python","Data Science","Kotlin Basics","Machine Learning","Natural Language Processing",
//        "VueJs","Java","Database"
//    )


//  2. For complex Objects

    private val courses = listOf<Course>(
        Course("Android", "John Dave", 20, 1499),
        Course("Python", "Smith ", 10, 1499),
        Course("Kotlin Basics", "Yuta", 10, 1499),
        Course("Data Science", "David", 25, 1499),
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lists)

// 1. For Simple List
//        listCourses.adapter = ArrayAdapter<String>(
//            this,
//            android.R.layout.simple_list_item_1,
//            android.R.id.text1,
//            courses
//        )
//
//        listCourses.setOnItemClickListener { _, _, position, _ ->
//            Toast.makeText(this,"Clicked On ${courses[position]}",Toast.LENGTH_SHORT).show()
//        }

//   2. For Complex Objects List

        listCourses.adapter = object : BaseAdapter() {
            override fun getCount() = courses.size

            override fun getItem(position: Int): Course = courses[position]

            override fun getItemId(position: Int): Long = getItem(position).hashCode().toLong()

            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val itemView = layoutInflater.inflate(R.layout.list_item_course,parent,false)
                val course = getItem(position)
                itemView.tvCourseName.text = course.name
                itemView.tvTeacherName.text = course.teacher
                itemView.tvCourseDetails.text = "Lectures : ${course.lectures} | Fees : ${course.fees}"

                return itemView
            }

        }
    }
}