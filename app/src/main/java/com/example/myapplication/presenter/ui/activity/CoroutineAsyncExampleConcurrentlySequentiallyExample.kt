package com.example.myapplication.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
//it is an example for 2 tasks run concurrently and based on result run another task sequentially
class CoroutineAsyncExampleConcurrentlySequentiallyExample : ComponentActivity() {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            funConcurrently()
        }
    }

    private fun funConcurrently() {
        coroutineScope.launch {
            val resDeferred = async { fetchDataFromNetwork() }
            val res1Deferred = async { fetchDataFromDatabase() }
          val res=  resDeferred.await()
            val res1=res1Deferred.await()

            funSequentially(res+res1)
        }
        //  result.await()
    }



private fun funSequentially(s: String) {
    Log.d("minitha", "sequentially"+s)
}

private suspend fun fetchDataFromDatabase(): String {
    Log.d("minitha", "fetchDataFromDatabase")
    delay(10000)
    Log.d("minitha", "after fetchDataFromDatabase")
    return "data from database"
}

private suspend fun fetchDataFromNetwork(): String {
    Log.d("minitha", "fetchDataFromNetwork")
    delay(15000)
    Log.d("minitha", "afterfetchDataFromNetwork")
    return "data from network"
}
}