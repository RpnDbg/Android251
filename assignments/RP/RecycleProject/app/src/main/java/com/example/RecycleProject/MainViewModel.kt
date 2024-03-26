package com.example.RecycleProject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.RecycleProject.databinding.ContentMain2Binding

class MainViewModel : AppCompatActivity() {
    private lateinit var binding: ContentMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflates the layout and sets it as the content view of the activity
        binding = ContentMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieves extras from the intent to get image ID, title, and detail
        val extras = intent.extras ?: return
        val imageID = extras.getInt("imageID")
        val title = extras.getString("title")
        val detail = extras.getString("detail")

        // Sets the image, title, and detail to their respective views in the layout
        binding.imageView2.setImageResource(imageID)
        binding.titleText2.text = title
        binding.detailsText2.text = detail
    }
}
