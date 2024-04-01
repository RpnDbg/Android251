package com.example.RecycleViewIntentProj

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

// Create an instance of the Data class to access data.
var data = Data()
// Retrieve titles, details, and images from the Data class.
private val titles = data.getTitles()
private val details = data.getDetails()
val images = data.getImages()

// Adapter class for RecyclerView.
class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    // ViewHolder class to hold the views of each item.
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        // Initialize views in the constructor.
        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            // Set click listener to handle item click events.
            itemView.setOnClickListener { v ->
                // Get the position of the clicked item.
                val position: Int = adapterPosition
                // Create an intent to start the second activity.
                val i = Intent(v.context,MainActivity2::class.java)
                // Pass image position, title, and detail to the intent.
                i.putExtra("imagePosition", position)
                i.putExtra("title",itemTitle.text.toString())
                i.putExtra("detail",itemDetail.text.toString())
                // Start the second activity.
                startActivity(v.context,i,null)
            }
        }
    }

    // Create ViewHolders.
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        // Inflate the card_layout view and return a ViewHolder.
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    // Bind data to views.
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        // Set text and image resources to views.
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])
    }

    // Return the total number of items in the dataset.
    override fun getItemCount(): Int {
        return titles.size
    }
}