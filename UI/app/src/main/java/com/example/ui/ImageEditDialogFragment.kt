package com.example.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.layout_bottom_sheet.view.*

class ImageEditDialogFragment : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.layout_bottom_sheet, container, false)
        val btnCancel = view.btnCancel
        val txtCamera = view.txtCamera
        val txtAddPhoto = view.txtAddPhoto
        val txtDelete = view.txtDelete


        btnCancel.setOnClickListener {
            dismiss()
        }

        txtCamera.setOnClickListener {
            Toast.makeText(requireContext(), "added", Toast.LENGTH_SHORT).show()
        }

        txtAddPhoto.setOnClickListener {
            Toast.makeText(requireContext(), "added", Toast.LENGTH_SHORT).show()
        }

        txtDelete.setOnClickListener {
            Toast.makeText(requireContext(), "added", Toast.LENGTH_SHORT).show()
        }


        return view
    }

    override fun getTheme(): Int {
        return R.style.BottomSheetTheme
    }

}