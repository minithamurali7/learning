package com.example.myapplication.presenter.ui.activity;

import android.util.Log;

 class TestInterface extends TestInheritance implements B {

  /*  @Override
    void inheritance() {
        super.inheritance();
        Log.d("minitha", "inheritance" );
    }*/

     @Override
     void inheritance() {
         super.inheritance();
     }

     public void test() {
        Log.d("minitha", "TestInterface" );
    }

    @Override
    public void test1() {
        Log.d("minitha", "interface method");
    }

    @Override
    public void test2() {
        Log.d("minitha", "interface method2");
    }

     @Override
     void method() {
         Log.d("minitha", "abstarct method2");
     }
 }

interface B {
    int b = 10;
     void test1();
    void test2();
}


