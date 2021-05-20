package com.example.learningboard

import android.content.ClipData
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_context_menu.*

class ContextMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val contact = arrayOf<String>("Himanshu","Rishabh","Praveen","Harsh")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context_menu)
        setSupportActionBar(findViewById(R.id.toolbar))


        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contact)
        listView.adapter = adapter
        registerForContextMenu(listView)



    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_context,menu)

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when(item!!.itemId){
            R.id.call->{
                Toast.makeText(applicationContext, "call ", Toast.LENGTH_LONG).show()
                return true
            }

            R.id.sms->{
                Toast.makeText(applicationContext, "call ", Toast.LENGTH_LONG).show()
                return true
            }
            else->super.onOptionsItemSelected(item)
        }


    }
}