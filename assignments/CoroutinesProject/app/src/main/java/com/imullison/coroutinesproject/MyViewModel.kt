package com.imullison.coroutinesproject

import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {

    // Lists to hold names and delays
    val names = ArrayList<String>()
    val delays = ArrayList<Long>()

    // Adds a new entry with a name and delay
    fun addEntry(name: String, delay: Long) {
        names += name
        delays += delay
    }

}
