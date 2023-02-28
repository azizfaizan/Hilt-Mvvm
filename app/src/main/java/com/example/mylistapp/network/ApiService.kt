package com.example.mylistapp.network

import com.example.mylistapp.model.PhotosModel
import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    suspend fun getPhotos(): List<PhotosModel>
}