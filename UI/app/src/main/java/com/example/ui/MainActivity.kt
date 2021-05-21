package com.example.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottomsheet_name.view.*
import kotlinx.android.synthetic.main.layout_bottom_sheet.view.*
import kotlinx.android.synthetic.main.layout_bottom_sheet.view.btnCancel

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        imgedt.setOnClickListener {
            val bottomSheetDialog:BottomSheetDialog = BottomSheetDialog(this,R.style.BottomSheetTheme)
            val sheetView  = LayoutInflater.from(applicationContext).inflate(R.layout.layout_bottom_sheet,null)

            sheetView.txtCamera.setOnClickListener {
                Toast.makeText(this,"added",Toast.LENGTH_SHORT).show()
            }
            sheetView.txtAddPhoto.setOnClickListener {
                Toast.makeText(this,"added",Toast.LENGTH_SHORT).show()
            }
            sheetView.txtDelete.setOnClickListener {
                Toast.makeText(this,"added",Toast.LENGTH_SHORT).show()
            }


            bottomSheetDialog.setContentView(sheetView)
            bottomSheetDialog.show()

            sheetView.btnCancel.setOnClickListener {
               bottomSheetDialog.cancel()
            }
        }

      btnName1.setOnClickListener {
          val bottomSheetDialog1 = BottomSheetDialog(this,R.style.BottomSheetTheme)
          val sheet  = LayoutInflater.from(applicationContext).inflate(R.layout.bottomsheet_name,null)

          sheet.btnUpdate.setOnClickListener {
                  Toast.makeText(this,"added",Toast.LENGTH_SHORT).show()
          }



          bottomSheetDialog1.setContentView(sheet)
          bottomSheetDialog1.show()

//          sheet.btnclose.setOnClickListener {
//              bottomSheetDialog1.cancel()
//          }
//
//          val intent = Intent(this,BottomSheetName::class.java)
//          startActivity(intent)
      }
    }
}