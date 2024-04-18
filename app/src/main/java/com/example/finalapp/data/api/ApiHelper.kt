package com.example.finalapp.data.api

class ApiHelper(private val apiInterface: ApiService) {
    suspend fun getData() = apiInterface.getData()
}