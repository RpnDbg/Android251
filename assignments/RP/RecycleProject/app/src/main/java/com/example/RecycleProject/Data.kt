package com.example.RecycleProject


class Data {
    // Function to get shuffled titles array.
    fun getTitles(): Array<String> {
        return titles.toList().shuffled().toTypedArray()
    }    // Function to get shuffled details array.
    fun getDetails(): Array<String> {
        return details.toList().shuffled().toTypedArray()
    } // Function to get shuffled images array.
    fun getImages(): IntArray {
        return images.toList().shuffled().toIntArray()
    }
    // Array of titles representing chapters.
    private val titles = arrayOf("Chapter One",
        "Chapter Two",
        "Chapter Three",
        "Chapter Four",
        "Chapter Five",
        "Chapter Six",
        "Chapter Seven",
        "Chapter Eight")
    // Array of details corresponding to each chapter.
    private val details = arrayOf("Item one details",
        "Item two details",
        "Item three details",
        "Item four details",
        "Item five details",
        "Item six details",
        "Item seven details",
        "Item eight details")
    // Array of image resources corresponding to each chapter.
    private val images = intArrayOf(R.drawable.android_image_1,
        R.drawable.android_image_2,
        R.drawable.android_image_3,
        R.drawable.android_image_4,
        R.drawable.android_image_5,
        R.drawable.android_image_6,
        R.drawable.android_image_7,
        R.drawable.android_image_8)

}