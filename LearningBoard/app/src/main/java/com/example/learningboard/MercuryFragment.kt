package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.learningboard.R
import kotlinx.android.synthetic.main.activity_mercury_fragment.view.*
import kotlinx.android.synthetic.main.activity_venus_fragment.view.*

class MercuryFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.activity_mercury_fragment,container,false)
        view.btnMecury!!.setOnClickListener {
            Toast.makeText(context,"Mercury Fragment", Toast.LENGTH_SHORT).show()
        }
        return view
    }
}