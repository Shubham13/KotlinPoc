package com.example.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottomsheet_name.view.*

class ActionBottomDialogFragment : BottomSheetDialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottomsheet_name, container, false)
        val btnUpdate = view.btnUpdate
        val nameEdtText = view.name_edit_text
        val nameInput = view.name_text_input
        val lastNameInput = view.last_name_input
        val lastNameEdtText = view.last_name_edittext
        val preferredNameInput = view.preferred_name_input
        val preferredNameEdtText = view.preferred_name_edittext


        btnUpdate.setOnClickListener {
            Toast.makeText(requireContext(), "Button Pressed", Toast.LENGTH_SHORT).show()
        }
        nameEdtText.setOnFocusChangeListener { v, hasFocus ->
           if(!hasFocus) {
                if (nameEdtText.text.toString().length < 6) {
                    nameInput.error = "Name Should be More than 6"
                }
               else{
                    nameInput.error = null
                }
            }
        }


        lastNameEdtText.setOnFocusChangeListener { v, hasFocus ->
            if(!hasFocus) {
                if (lastNameEdtText.text.toString().length < 6) {
                    lastNameInput.error = "Name Should be More than 6"
                }
                else{
                    lastNameInput.error = null
                }
            }
        }

        preferredNameEdtText.setOnFocusChangeListener { v, hasFocus ->
            if(!hasFocus){
                if (preferredNameEdtText.text.toString().length < 6) {
                    preferredNameInput.error = "Name Should be More than 6"
                }
                else{
                    preferredNameInput.error = null
                }
            }
        }


        return view
    }

    override fun getTheme(): Int {
        return R.style.BottomSheetTheme
    }
}