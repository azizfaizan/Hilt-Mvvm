package com.example.mylistapp.repository

import com.example.mylistapp.model.PhotosModel
import com.example.mylistapp.network.ApiDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(private val apiDataSource: ApiDataSource) {
    fun getPhotos(): Flow<List<PhotosModel>> = flow {
        val response = apiDataSource.getPhotos()
        emit(response)
    }.flowOn(Dispatchers.IO)
}