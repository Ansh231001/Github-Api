package com.example.finalapp.ui.homeScreen.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.finalapp.data.repository.HomeRepository
import com.example.finalapp.utils.Resource
import kotlinx.coroutines.Dispatchers

class HomeViewModel(private val homeRepository: HomeRepository):ViewModel() {
    fun getData()= liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            val res = homeRepository.getData()
            emit(Resource.success(data=homeRepository.getData()))
        } catch (exception:Exception){
//            Log.e("ViewModel", "API Error: ${exception.message ?: "Unknown Error"}")
            emit(Resource.error(data = null, message = exception.message ?: "ERROR OCCURRED"))
        }
    }
}