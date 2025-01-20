package com.example.myapplication.presenter.ui.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StartServiceWithLaunchCoroutine : Service() {
    val coroutineScope= CoroutineScope(Dispatchers.IO)
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        Log.d("minitha","service created")
        super.onCreate()
    }

    override fun onDestroy() {
        Log.d("minitha","service destroyed")
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("minitha","service started"+Thread.currentThread().name)

        coroutineScope.launch {
            Log.d("minitha","coroutine started"+Thread.currentThread().name)
            Thread.sleep(20000)
            withContext(Dispatchers.Main){
                Toast.makeText(applicationContext,"Download finished",Toast.LENGTH_SHORT).show()
            }
          //  stopSelf()
            Log.d("minitha","coroutine ended"+Thread.currentThread().name)
        }
        return START_STICKY
    }
}