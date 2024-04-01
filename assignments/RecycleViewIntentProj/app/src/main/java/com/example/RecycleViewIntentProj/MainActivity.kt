package com.example.RecycleViewIntentProj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.RecycleViewIntentProj.databinding.ContentMainBinding

class MainActivity : AppCompatActivity() {

    // Declare variables for layout manager, adapter, and binding.
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private lateinit var binding: ContentMainBinding

    // Function called when the activity is created.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding using the auto-generated binding class.
        binding = ContentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize layout manager.
        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        // Initialize adapter.
        adapter = RecyclerAdapter()
        binding.recyclerView.adapter = adapter
    }
}