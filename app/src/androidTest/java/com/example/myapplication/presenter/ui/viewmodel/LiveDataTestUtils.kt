package com.example.myapplication.presenter.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

fun <T> LiveData<T>.getOrAwaitValue(): T {
    val latch = CountDownLatch(1)
    var data: T? = null
    val observer = object : Observer<T> {
        override fun onChanged(value: T) {
            data = value
            removeObserver(this)
            latch.countDown()
        }

    }
    this.observeForever(observer)
    try {
        if (!latch.await(2, TimeUnit.SECONDS)) {
            throw Exception("Time out")
        }
    } finally {
        removeObserver(observer)
    }

    return data as T
}