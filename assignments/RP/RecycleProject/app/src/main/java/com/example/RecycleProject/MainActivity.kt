package com.example.RecycleProject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.RecycleProject.databinding.ContentMainBinding

class MainActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private lateinit var binding: ContentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflates the layout and sets it as the content view of the activity
        binding = ContentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Sets up the RecyclerView with a LinearLayoutManager
        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        // Sets up the RecyclerView adapter
        adapter = RecyclerAdapter()
        binding.recyclerView.adapter = adapter

        // Retrieves extras from the intent to get image ID, title, and detail
        val extras = intent.extras ?: return
        val imageID = extras.getInt("imageID")
        val title = extras.getString("title")
        val detail = extras.getString("detail")

        // Calls function with the retrieved data
        sendTonext(imageID, title.toString(), detail.toString())
    }

    // Sends the image ID, title, and detail to the second activity
    fun sendTonext(imageID: Int, title: String, detail: String) {
        val intent2 = Intent(this, MainViewModel::class.java)
        intent2.putExtra("imageID", imageID)
        intent2.putExtra("title", title)
        intent2.putExtra("detail", detail)
        startActivity(intent2)
    }
}
