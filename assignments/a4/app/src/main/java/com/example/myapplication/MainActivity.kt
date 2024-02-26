package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val enteredNames = mutableListOf<String>()
    private val ENTERED_NAMES_KEY = "enteredNamesKey"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        binding.button.setOnClickListener {
            val enteredText = binding.editTextText.text.toString()

            if (enteredText.isNotBlank()) {
                enteredNames.add(enteredText)
                displayEnteredNames()
            } else {
                binding.textView.text = "No Name Entered"
            }
        }

        savedInstanceState?.let {
            enteredNames.addAll(it.getStringArrayList(ENTERED_NAMES_KEY) ?: emptyList())
            displayEnteredNames()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putStringArrayList(ENTERED_NAMES_KEY, ArrayList(enteredNames))
        super.onSaveInstanceState(outState)
    }

    private fun displayEnteredNames() {
        val namesString = enteredNames.joinToString(", ")
        binding.textView.text = namesString
    }
}