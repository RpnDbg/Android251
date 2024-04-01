package com.example.RecycleViewIntentProj

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.RecycleViewIntentProj.databinding.ContentMain2Binding


class MainActivity2 : AppCompatActivity() {

    // Declare binding variable.
    private lateinit var binding: ContentMain2Binding

    // Function called when the activity is created.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding using the auto-generated binding class.
        binding = ContentMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve extras passed from the intent.
        val extras = intent.extras ?: return
        // Retrieve image, title, and detail information from the extras.
        val image = images[extras.getInt("imagePosition")]
        val title = extras.getString("title")
        val detail = extras.getString("detail")

        // Set image resource, title text, and detail text in the layout.
        binding.imageView2.setImageResource(image)
        binding.titleText2.text = title
        binding.detailsText2.text = detail
    }
}