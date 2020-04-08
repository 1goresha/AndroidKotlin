package com.example.lifecycle

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class MyObserver : LifecycleObserver{

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun toastsOnAny(source : LifecycleOwner,  event : Lifecycle.Event){
        println(event.toString())
    }
}