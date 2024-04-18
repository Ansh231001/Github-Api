package com.example.finalapp.data.repository

import com.example.finalapp.data.api.ApiHelper

class HomeRepository(private val apiHelper: ApiHelper) {
    suspend fun getData()=apiHelper.getData()
}