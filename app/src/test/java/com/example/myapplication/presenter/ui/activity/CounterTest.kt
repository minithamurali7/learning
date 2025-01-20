package com.example.myapplication.presenter.ui.activity

import org.junit.Assert.*

import org.junit.Test

class CounterTest {

    @Test
    fun validate() {

        val amt= 0
        val desc =""
        val counter = Counter()
        val result = counter.validate(amt,desc)
        assertEquals(false ,result)

    }
}