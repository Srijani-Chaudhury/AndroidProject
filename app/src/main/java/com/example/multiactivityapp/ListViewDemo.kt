package com.example.multiactivityapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListViewDemo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.demolist)

        val myList:ListView=findViewById(R.id.myList)

        val cities= arrayListOf("Kolkata","Delhi","Pune","Mumbai","Kochi","Gokarna","Karnatak","Siachen","KAshmir","Hashimi","Kolapur","Ahmednagar","Ranchi","Rajasthan","Bihar","KAshmir","Hashimi","Kolapur","Ahmednagar","Ranchi","Rajasthan","Bihar")
        val adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cities)

        myList.adapter=adapter

        myList.setOnItemClickListener{
            parent,view,position,id->
            val country=(view as TextView).text
            Toast.makeText(this,"You clicked $country",Toast.LENGTH_SHORT).show()

        }
    }
}