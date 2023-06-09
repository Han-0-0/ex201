package com.example.ex201;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

public class MyObserver implements DefaultLifecycleObserver {
    @Override
    public void onResume(LifecycleOwner owner) {
//        connect()
    }

    @Override
    public void onPause(LifecycleOwner owner) {
//        disconnect()
    }
}

