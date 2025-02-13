package com.example.multiactivityapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract

class MultiActivityContract:ActivityResultContract<Array<String>,String?>() {
    override fun createIntent(context: Context, input: Array<String>): Intent {
        var intent=Intent(context,SecondActivity::class.java)
        var bundle=Bundle()
        bundle.putString("Username",input[0])
        bundle.putString("Password",input[1])
        intent.putExtras(bundle)
        return intent

    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        var msg:String?=intent?.getStringExtra("Message")
        return msg
    }
}