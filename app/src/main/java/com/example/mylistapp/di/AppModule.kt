package com.example.mylistapp.di

import com.example.mylistapp.network.ApiService
import com.example.mylistapp.utlis.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

}