package com.example.myapplication.presenter.ui.activity

class Counter {

    fun validate(amount:Int,desc:String) : Boolean{
        return (amount > 0) && desc.isNotEmpty()
    }



}