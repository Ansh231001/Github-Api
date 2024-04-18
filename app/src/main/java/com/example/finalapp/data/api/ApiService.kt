package com.example.finalapp.data.api

import com.example.finalapp.data.model.UsersItem
import retrofit2.http.GET

interface ApiService {
    @GET("/users")
    suspend fun getData(): List<UsersItem>
}