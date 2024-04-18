package com.example.finalapp.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.finalapp.data.api.ApiHelper
import com.example.finalapp.data.repository.HomeRepository
import com.example.finalapp.ui.homeScreen.viewmodel.HomeViewModel

class ViewModelFactory(private val apiHelper: ApiHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(HomeRepository(this.apiHelper)) as T
        }
        throw java.lang.IllegalArgumentException("Unknown class name")
    }
}