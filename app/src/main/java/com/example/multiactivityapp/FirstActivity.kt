package com.example.multiactivityapp

import android.app.Activity
import android.app.ComponentCaller
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FirstActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.firstlayout)

        var editUsername : EditText = findViewById(R.id.editUsername)
        var editPassword: EditText=findViewById((R.id.editPassword))
        var btnNext:Button=findViewById(R.id.buttonNext)

        btnNext.setOnClickListener {
//            var intent=Intent(this,SecondActivity::class.java)
//            var bundle=Bundle()
//            bundle.putString("Username",editUsername.text.toString())
//            bundle.putString("Password",editPassword.text.toString())
//            intent.putExtras(bundle)
//            startActivityForResult(intent, requestCode=1000)
            var myarr= arrayOf(editUsername.text.toString(),editPassword.text.toString())
            go.launch(myarr)

        }
    }

    private val go=registerForActivityResult(MultiActivityContract()){
        result->
        if (result!=null)
            Toast.makeText(this,"Message: $result",Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this,"no message",Toast.LENGTH_LONG).show()
    }


}