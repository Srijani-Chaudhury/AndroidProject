package com.example.multiactivityapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FirstActivity_Org : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.firstlayout)

        var editUsername : EditText = findViewById(R.id.editUsername)
        var editPassword: EditText=findViewById((R.id.editPassword))
        var btnNext:Button=findViewById(R.id.buttonNext)

        btnNext.setOnClickListener {
            var intent=Intent(this,SecondActivity::class.java)
            var bundle=Bundle()
            bundle.putString("Username",editUsername.text.toString())
            bundle.putString("Password",editPassword.text.toString())
            intent.putExtras(bundle)
            startActivity(intent)
        }

    }
}