package com.example.RecycleViewIntentProj

import com.example.RecycleViewIntentProj.R

class Data {
    // Function to get random titles for the list items.
    fun getTitles(): Array<String> {
        // Shuffle the list of titles and convert it to an array.

        return titles.toList().shuffled().toTypedArray()
    }
    // Function to get random details for the list items.
    fun getDetails(): Array<String> {
        return details.toList().shuffled().toTypedArray()
    }
    // Function to get random images for the list items.
    fun getImages(): IntArray {
        return images.toList().shuffled().toIntArray()
    }
    // Predefined list of titles for the list items.
    private val titles = arrayOf("Chapter One", "Chapter Two", "Chapter Three", "Chapter Four",
        "Chapter Five", "Chapter Six", "Chapter Seven", "Chapter Eight")

    // Predefined list of details for the list items.
    private val details = arrayOf("Item one details", "Item two details", "Item three details",
        "Item four details", "Item five details", "Item six details", "Item seven details", "Item eight details")

    // Predefined list of image resources for the list items.
    private val images = intArrayOf(R.drawable.android_image_1, R.drawable.android_image_2,
        R.drawable.android_image_3, R.drawable.android_image_4, R.drawable.android_image_5,
        R.drawable.android_image_6, R.drawable.android_image_7, R.drawable.android_image_8)

}