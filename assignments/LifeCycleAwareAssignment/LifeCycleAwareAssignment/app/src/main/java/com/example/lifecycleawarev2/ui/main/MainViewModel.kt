package com.example.lifecycleawarev2.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    // to hold static properties
    companion object {

        private var result: MutableLiveData<String> = MutableLiveData()
        // to accumulate messages
        private var msg = ""

        // Function to add status to the result
        fun addResult(status: String) {
            msg += status
            // Update the value of MutableLiveData
            result.value = msg
        }
    }

    // to get the MutableLiveData
    fun getStatus(): MutableLiveData<String> {
        return result
    }
}
