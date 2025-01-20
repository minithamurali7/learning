package com.example.myapplication.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.myapplication.presenter.ui.model.UserParcelable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SerializableParcelableExample : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            CoroutineScope(Dispatchers.Main).launch {
                delay(5000)
                function1()
            }


        }

    private fun function1() {
        val intent=Intent(this,SerializableParcelableExample2::class.java)
        val user= UserParcelable("minitha",33)
        intent.putExtra("user",user)
        startActivity(intent)
    }


}