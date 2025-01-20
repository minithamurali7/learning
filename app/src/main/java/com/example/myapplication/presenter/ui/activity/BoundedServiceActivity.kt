package com.example.myapplication.activity

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.myapplication.R
import com.example.myapplication.presenter.ui.service.BoundedService


class BoundedServiceActivity : ComponentActivity(){
    var boundedService: BoundedService?=null
    var isBound=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.start)
        val stopButton = findViewById<Button>(R.id.stop)

        startButton.setOnClickListener {
            boundedService?.play("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3")

        }

        stopButton.setOnClickListener {
            boundedService?.stop()
        }
    }

    val serviceConnection = object : ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as BoundedService.MusicBinder
            boundedService=binder.getService()
            isBound=true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isBound = false
        }

    }

    override fun onStop() {
        if(isBound)
        {
            unbindService(serviceConnection)
            isBound=false
        }
        super.onStop()
    }
    override fun onStart() {
        bindService(Intent(this, BoundedService::class.java),serviceConnection,BIND_AUTO_CREATE)
        super.onStart()
    }
}