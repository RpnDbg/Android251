package com.imullison.coroutinesproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val viewModel: MyViewModel) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var name: String = ""
            // Sets the name and updates the view if it's not empty
            set(value) {
                field = value
                if (value != "") updateView()
            }

        var delay: Long = -1
            // Sets the delay and updates the view if it's greater than -1
            set(value) {
                field = value
                if (value > -1) updateView()
            }

        // Updates the view with the current name and delay
        private fun updateView() {
            // Finds the TextView in the layout and sets its text
            itemView.findViewById<TextView>(R.id.cardText).text =
                "The name is $name and the delay is $delay milliseconds"
        }


    }

    // Creates a new ViewHolder with the layout for each item in the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false))
    }

    // Binds data to the ViewHolder for each item in the RecyclerView
    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.name = viewModel.names[position]
        holder.delay = viewModel.delays[position]
    }

    // Returns the total number of items in the data set
    override fun getItemCount(): Int {
        return viewModel.names.size
    }

}
