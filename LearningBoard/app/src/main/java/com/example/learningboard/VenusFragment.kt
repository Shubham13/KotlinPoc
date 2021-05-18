package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import com.example.learningboard.R
import kotlinx.android.synthetic.main.activity_venus_fragment.view.*
import java.util.zip.Inflater

class VenusFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.activity_venus_fragment,container,false)
        view.btnVenus!!.setOnClickListener {
            Toast.makeText(context,"Venus Fragment",Toast.LENGTH_SHORT).show()
        }
        return view
    }
}