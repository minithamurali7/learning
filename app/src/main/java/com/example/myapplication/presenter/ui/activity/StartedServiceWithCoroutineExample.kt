package com.example.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.myapplication.R
import com.example.myapplication.presenter.ui.service.StartServiceWithLaunchCoroutine

class StartedServiceWithCoroutineExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.start)
        val stopButton = findViewById<Button>(R.id.stop)
        startButton.setOnClickListener {
            val intent = Intent(this, StartServiceWithLaunchCoroutine::class.java)
            startService(intent)
        }

        stopButton.setOnClickListener {
            val intent = Intent(this, StartServiceWithLaunchCoroutine::class.java)
            stopService(intent)
        }
    }
}

