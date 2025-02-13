package com.example.multiactivityapp

import android.Manifest
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.ImageBitmap
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CameraActivity : ComponentActivity() {
    var myImg:ImageView?=null
    var btnOk:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cameralayout)
        myImg=findViewById(R.id.myImg)
        btnOk=findViewById(R.id.btnCamera)

        checkPermission()

        btnOk?.setOnClickListener {
            val cameraIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            takePicture.launch(cameraIntent)
        }
    }
    private val takePicture=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result->
        val photo:Bitmap=result.data?.extras?.get("data") as Bitmap
        myImg?.setImageBitmap(photo)
    }
    private val requestPermission=registerForActivityResult(
        ActivityResultContracts.RequestPermission()){
        isGranted->
          if(isGranted)
              Toast.makeText(this,"permission is granted",Toast.LENGTH_LONG).show()
          else{
              Toast.makeText(this,"permission not granted",Toast.LENGTH_LONG).show()
              btnOk?.isEnabled=false
          }
    }
    fun checkPermission(){
        requestPermission.launch(Manifest.permission.CAMERA)
    }

}