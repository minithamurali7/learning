package com.example.myapplication.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.example.myapplication.presenter.ui.model.UserParcelable

class SerializableParcelableExample2 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val user=  intent.getParcelableExtra<UserParcelable>("user")
   //  val user=  intent.getSerializableExtra("user") as User
        Log.d("minitha",user!!.name)
    }
}