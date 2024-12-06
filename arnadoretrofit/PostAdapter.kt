package com.example.arnadoretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(private val postList: List<ExampleResponse>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    // Create a ViewHolder object
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_2, parent, false)  // Simple list item layout
        return PostViewHolder(itemView)
    }

    // Bind data to the ViewHolder
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.titleTextView.text = post.title
        holder.bodyTextView.text = post.body
    }

    // Return the size of the list
    override fun getItemCount(): Int {
        return postList.size
    }

    // Define the ViewHolder that represents each row in the list
    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(android.R.id.text1)
        val bodyTextView: TextView = itemView.findViewById(android.R.id.text2)
    }
}
