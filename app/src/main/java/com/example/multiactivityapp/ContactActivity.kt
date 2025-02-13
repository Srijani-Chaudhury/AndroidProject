package com.example.multiactivityapp

import android.Manifest
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContactActivity : ComponentActivity() {
    private var myList:ListView?= null

    private val checkPermission=registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ){
        permissions->
        var flag=0
        permissions.forEach{
            if(it.value){
                flag++
            }
            if(flag==2){
                Toast.makeText(this,"permissions are granted",Toast.LENGTH_LONG).show()
                loadContracts()
            }else{
                Toast.makeText(this,"Some permission denied",Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listviewlayout)
        checkContactPermission()
        myList=findViewById(R.id.contacts)

    }

    private fun checkContactPermission(){
        checkPermission.launch(arrayOf(Manifest.permission.READ_CONTACTS,Manifest.permission.WRITE_CONTACTS))
    }

    private fun loadContracts(){
        var cursor=contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null)
        val clist=ArrayList<String>()
        if(cursor!=null && cursor.moveToFirst() ){
            while(cursor.moveToNext()){
                val name=cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                val number=cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER))
                clist.add("name: $name and number $number")
            }
        }
        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,clist)
        myList?.adapter=adapter
        cursor?.close()
    }
}