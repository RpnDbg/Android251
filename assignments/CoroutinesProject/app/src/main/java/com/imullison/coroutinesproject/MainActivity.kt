package com.imullison.coroutinesproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.imullison.coroutinesproject.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // Creates a coroutine scope with the main dispatcher
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    // Gets the view model using activity viewModels delegate
    private val viewModel: MyViewModel by viewModels()

    private lateinit var recyclerAdapter: RecyclerAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Sets up the RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = RecyclerAdapter(viewModel)
        binding.recyclerView.adapter = recyclerAdapter
    }

    // Function to add a new name when the button is clicked
    fun addName(view: View) {
        val name = binding.nameInput.text.toString()
        coroutineScope.launch {
            // Launches a coroutine to add the name with a random delay
            val delay = hold().await()
            viewModel.addEntry(name, delay)
            // Notifies the adapter of the new item
            recyclerAdapter.notifyItemInserted(recyclerAdapter.itemCount)
        }
    }

    // Suspended function to simulate a delay
    suspend fun hold() = coroutineScope.async {
        // Generates a random delay between 1 to 10 seconds
        val delayMs = (Random.nextLong(10) + 1) * 1000
        delay(delayMs)
        // Returns the delay
        return@async delayMs
    }
}
