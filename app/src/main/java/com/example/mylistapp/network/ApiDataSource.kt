package com.example.mylistapp.network

import com.example.mylistapp.model.PhotosModel
import javax.inject.Inject


class ApiDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getPhotos(): List<PhotosModel> = apiService.getPhotos()
}