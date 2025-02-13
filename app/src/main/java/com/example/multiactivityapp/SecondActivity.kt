package com.example.multiactivityapp

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secondlayout)
        var textData :TextView=findViewById(R.id.textView)
        var btnBack:Button=findViewById(R.id.btnBack)
        var edtMsg:EditText=findViewById(R.id.editMesg)
        var bundle=intent.extras
        var uname:String?=bundle?.getString("Username")
        var password:String?=bundle?.getString("Password")

        textData.setText("Username: $uname \n Password:$password")

        btnBack.setOnClickListener {
            intent.putExtra("Message",edtMsg.text.toString())
            setResult(Activity.RESULT_OK,intent)
            finish()
        }

    }
}