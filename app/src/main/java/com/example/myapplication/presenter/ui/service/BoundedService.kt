package com.example.myapplication.presenter.ui.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.util.Log

class BoundedService : Service() {
    private val binder = MusicBinder()
    var mediaPlayer:MediaPlayer?=null
    override fun onBind(intent: Intent?): IBinder? {
      return binder
    }

    inner class MusicBinder : Binder(){
         fun getService(): BoundedService {
             return this@BoundedService
         }
    }

    override fun onCreate() {
        Log.d("minitha","oncreate")
        mediaPlayer=MediaPlayer()
        super.onCreate()
    }

    override fun onDestroy() {
        Log.d("minitha","onDestroy")
        if(mediaPlayer!=null)
            mediaPlayer!!.release()
        super.onDestroy()
    }

    fun play(song:String) {
        try {
            Log.d("minitha","onPlay")
            mediaPlayer!!.setDataSource(song)
            mediaPlayer!!.prepare()
            mediaPlayer!!.start()
        } catch (e: Exception)
        {
            Log.d("minitha", ""+ e.localizedMessage)
            e.printStackTrace()
        }
    }

    fun pause(){
        if(mediaPlayer!!.isPlaying)
        mediaPlayer!!.pause()
    }

    fun stop(){
        Log.d("minitha","stop")
        if(mediaPlayer!!.isPlaying)
        mediaPlayer!!.stop()

    }
}