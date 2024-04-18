package com.example.finalapp.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val BASE_URL="https://api.github.com"
    private val retrofit : Retrofit by lazy{
        val interceptor= HttpLoggingInterceptor()
        interceptor.level= HttpLoggingInterceptor.Level.BODY

        val client= OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiService:ApiService by lazy { retrofit.create(ApiService::class.java) }
}