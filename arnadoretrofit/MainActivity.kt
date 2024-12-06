
package com.example.arnadoretrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Load fake data
        getFakeExampleData()
    }

    private fun getFakeExampleData() {
        try {
            val inputStream = assets.open("fake_posts.json")  // Load the fake data from assets
            val reader = InputStreamReader(inputStream)
            val type: Type = object : TypeToken<List<ExampleResponse>>() {}.type
            val fakeData: List<ExampleResponse> = gson.fromJson(reader, type)

            // Set up RecyclerView with data
            postAdapter = PostAdapter(fakeData)
            recyclerView.adapter = postAdapter

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

data class ExampleResponse(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)