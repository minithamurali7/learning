package com.example.myapplication.presenter.ui.activity

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.myapplication.R

class OrientationChange : ComponentActivity() {
    val name=  findViewById<EditText>(R.id.et_value)
    val start=  findViewById<Button>(R.id.start)
    val stop=  findViewById<Button>(R.id.stop)
    val value=  findViewById<TextView>(R.id.tv_value)
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("minitha","oncreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        start.setOnClickListener {
            if(name.text.toString().isNotEmpty()){
                val res=name.text.toString().toInt()+1
                value.text=res.toString()
            }

        }
    }

    override fun onDestroy() {
        Log.d("minitha","ondestroy")
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        Log.d("minitha","onConfigurationChanged")
        super.onConfigurationChanged(newConfig)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        value.text=savedInstanceState.getString("addValue")
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("addValue",value.text.toString())
    }

}