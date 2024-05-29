package com.example.randomimage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.randomimage.databinding.ActivityMainBinding
import com.example.randomimage.network.NetworkClient
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var data: List<String> = listOf(
            "String1", "New String", "another string", "cat", "dog", "asdasd"
        )

        binding.myList.layoutManager = LinearLayoutManager(this@MainActivity)
        val myAdapter = ListAdapter()
        binding.myList.adapter = myAdapter

        myAdapter.setList(data)

        val networkClient = NetworkClient()
        networkClient.initClient()

        networkClient.getDogImage()
    }
}