package com.example.multiactivityapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class URLActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.thirdlayout)

        val editUrl:EditText=findViewById(R.id.editUrl)
        val btnOk:Button=findViewById(R.id.btnOpen)

        btnOk.setOnClickListener {
            val intent=Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(editUrl.text.toString()))
            startActivity(intent)
        }
    }
}