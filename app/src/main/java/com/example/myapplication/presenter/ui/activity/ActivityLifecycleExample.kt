package com.example.myapplication.activity

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.myapplication.R

class ActivityLifecycleExample : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("minitha", "oncreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val name = findViewById<TextView>(R.id.tv_value)
        name.setOnClickListener {
            val uri = Uri.parse("flipr://dashboard")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

    @JvmName(name = "sampleFun")
    fun sample() : String {
        return "Hello from Kotlin!"

    }

    override fun onStart() {
        Log.d("minitha", "start")
        super.onStart()
    }

    override fun onPause() {
        Log.d("minitha", "pause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("minitha", "stop")
        super.onStop()
    }

    override fun onResume() {
        Log.d("minitha", "resuume")
        super.onResume()
    }

    override fun onRestart() {
        Log.d("minitha", "restart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d("minitha", "destroy")
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }
}