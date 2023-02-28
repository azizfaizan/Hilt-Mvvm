package com.example.mylistapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mylistapp.viewmodel.PostViewModel
import com.example.mylistapp.databinding.ActivityMainBinding
import com.example.mylistapp.model.PhotosModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val postViewModel: PostViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: com.example.mylistapp.adapter.ListAdapter
    private lateinit var list:ArrayList<PhotosModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postViewModel.getPhotos.observe(this, Observer {
            list= it.toList() as ArrayList<PhotosModel>

            binding.rvItem.layoutManager = LinearLayoutManager(this)
            adapter=com.example.mylistapp.adapter.ListAdapter(it){
                startActivity(Intent(this, DetailPage::class.java).apply {
                    putExtra("title", list[it].title)
                    putExtra("img", list[it].url)
                    putExtra("album", list[it].albumId)
//
                })
            }
            binding.rvItem.adapter=adapter
        })
    }
}