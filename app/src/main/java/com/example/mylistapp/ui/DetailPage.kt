package com.example.mylistapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mylistapp.R
import com.example.mylistapp.databinding.ActivityDetailPageBinding
import com.example.mylistapp.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class DetailPage : AppCompatActivity() {

    private lateinit var binding: ActivityDetailPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        readIntent()
    }

    private fun readIntent() {
        binding.title.text = intent.getStringExtra("title")
        binding.album.text = intent.getIntExtra("album",0).toString()
        Picasso.get()
            .load(intent.getStringExtra("img"))
            .into(binding.img);
    }
}