package com.example.myapplication.presenter.ui.activity

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.myapplication.R
import java.util.concurrent.TimeUnit

class WorkManagerExample : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bnStart = findViewById<Button>(R.id.start)
        val bnStop = findViewById<Button>(R.id.stop)


        bnStart.setOnClickListener {
            oneTimeWorkRequest()
        }

        bnStop.setOnClickListener {
            periodicWorkRequest()
        }
    }

    private fun periodicWorkRequest() {
        val constraints =
            Constraints.Builder().setRequiredNetworkType(NetworkType.NOT_REQUIRED).build()
        val workRequest = PeriodicWorkRequestBuilder<com.example.myapplication.presenter.ui.activity.MyWorker>(15,TimeUnit.MINUTES).setConstraints(constraints )
        WorkManager.getInstance(this).enqueueUniquePeriodicWork("id",ExistingPeriodicWorkPolicy.KEEP,workRequest.build())
    }

    private fun oneTimeWorkRequest() {
        val constraints =
            Constraints.Builder().setRequiredNetworkType(NetworkType.NOT_REQUIRED).build()
        val workRequest = OneTimeWorkRequestBuilder<com.example.myapplication.presenter.ui.activity.MyWorker>().setConstraints(constraints).build()
        WorkManager.getInstance(this).enqueue(workRequest)
    }
}