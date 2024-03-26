package com.example.RecycleProject

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Instantiate the Data class to retrieve titles, details, and images.
var data = Data()
private val titles = data.getTitles() // Retrieve titles
private val details = data.getDetails() // Retrieve details
private val images = data.getImages() // Retrieve images

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Initialize views.
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        // Initialize views in the constructor.
        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            // Set click listener to the itemView.
            itemView.setOnClickListener {
                // Call sendInfo method passing imageID, title, and detail.
                sendInfo(R.id.itemImage, itemTitle.text.toString(), itemDetail.text.toString())
            }
        }
    }

    // Method to send information via intent.
    fun sendInfo(imageID: Int, title: String, detail: String) {
        // Create an intent with a custom action.
        val intent = Intent("myMessage")
        // Add extras to the intent.
        intent.putExtra("imageID", imageID)
        intent.putExtra("title", title)
        intent.putExtra("detail", detail)
    }

    // Method to create ViewHolders.
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        // Inflate the card_layout view and return a ViewHolder.
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        // Set text and image resources to views.
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}
