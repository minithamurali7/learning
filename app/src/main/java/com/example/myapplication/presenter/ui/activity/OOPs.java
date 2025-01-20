package com.example.myapplication.presenter.ui.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;

import com.example.myapplication.activity.ActivityLifecycleExample;

public class OOPs extends ComponentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TestInterface a = new TestInterface();
        a.inheritance();
        a.test();
        a.test1();
        a.test2();

    }

    ActivityLifecycleExample sample = new ActivityLifecycleExample();
    String message = sample.sampleFun();

}