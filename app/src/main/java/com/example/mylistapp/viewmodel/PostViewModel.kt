package com.example.mylistapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.mylistapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val getPhotos = repository.getPhotos()
        .catch { e ->
            Log.d("TAG", "PostViewModel: " + e.message)
        }.asLiveData()
}