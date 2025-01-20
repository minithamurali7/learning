package com.example.myapplication.presenter.ui.activity


import android.app.Activity
import android.os.Bundle


class SynchronizationExample : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main1()
    }
}

fun main1() {
    var count = 0

    @Synchronized
    fun increment() {
        count++
    }

    @Synchronized
    fun getCount(): Int {
        return count
    }

    val thread1 = Thread {
        repeat(10000) {
            increment()
        }

    }
    val thread2 = Thread {
        repeat(10000) {
            increment()
        }
    }
    thread1.start()
    thread2.start()
    thread1.join()
    thread2.join()

    println(getCount())
}

