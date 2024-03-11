package com.example.lifecycleawarev2

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.example.lifecycleawarev2.ui.main.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalTime

class DemoObserver: LifecycleObserver {
    // Lifecycle event handlers
    private val LOG_TAG = "DemoObserver"
    var mvm = MainViewModel
    // Function to get current date and time
    private fun getDateTime():String{
        return LocalTime.now().toString()
    }
    // Define event handlers for lifecycle events
    // Call addResult function of MainViewModel to add a log message
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.i(LOG_TAG, "onResume")
        mvm.addResult("onResume was fired on " + getDateTime() + "\n**********\n")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.i(LOG_TAG, "onPause")
        mvm.addResult("onPause was fired on "+getDateTime()+"\n**********\n")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.i(LOG_TAG, "onCreate")
        mvm.addResult("onCreate was fired on "+getDateTime()+"\n**********\n")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.i(LOG_TAG, "onStart")
        mvm.addResult("onStart was fired on "+getDateTime()+"\n**********\n")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.i(LOG_TAG, "onStop")
        mvm.addResult("onStop was fired on "+getDateTime()+"\n**********\n")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.i(LOG_TAG, "onDestroy")
        mvm.addResult("onDestroy was fired on "+getDateTime()+"\n**********\n")
    }
}