package com.example.finalapp.ui.homeScreen.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalapp.data.api.ApiHelper
import com.example.finalapp.data.api.RetrofitBuilder
import com.example.finalapp.data.model.UsersItem
import com.example.finalapp.databinding.ActivityMainBinding
import com.example.finalapp.ui.base.ViewModelFactory
import com.example.finalapp.ui.homeScreen.adaptor.HomeAdapter
import com.example.finalapp.ui.homeScreen.viewmodel.HomeViewModel
import com.example.finalapp.utils.Status


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var  myAdapter: HomeAdapter
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setViewModel()
        setupAdaptor()
        setupObserver()
    }

    private fun setupObserver() {
        homeViewModel.getData().observe(this){
            it?.let{resource->
                when(resource.status){
                    Status.SUCCESS->{
                        binding.rvMain.visibility = View.VISIBLE
                        resource.data?.let{user -> retData(user)}
                    }
                    Status.ERROR->{
                        binding.rvMain.visibility = View.GONE
                    }
                    Status.LOADING->{
                        binding.rvMain.visibility = View.VISIBLE
//                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }

                }
            }
        }
    }

    private fun retData(user: List<UsersItem>) {
        Log.d("RES", "$user")
        myAdapter.apply {
            addData(user)
            notifyDataSetChanged()
        }
    }


    private fun setupAdaptor() {
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        myAdapter = HomeAdapter(arrayListOf())
        binding.rvMain.addItemDecoration(
            DividerItemDecoration(
                binding.rvMain.context,
                (binding.rvMain.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.rvMain.adapter = myAdapter
    }

    private fun setViewModel() {
        homeViewModel = ViewModelProvider(this, ViewModelFactory(ApiHelper(RetrofitBuilder.apiService)))[HomeViewModel::class.java]
    }
}