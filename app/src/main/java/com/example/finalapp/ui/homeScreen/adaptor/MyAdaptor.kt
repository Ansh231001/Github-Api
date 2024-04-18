package com.example.finalapp.ui.homeScreen.adaptor

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.finalapp.data.model.UsersItem
import com.example.finalapp.databinding.ListItemBinding


class HomeAdapter(private val list:ArrayList<UsersItem>):
    RecyclerView.Adapter<HomeAdapter.UserListHolder>(){

    inner class UserListHolder(private val binding: ListItemBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(user: UsersItem){
            binding.apply {
                textView.text = user.login
                Glide.with(binding.Image.context).load(user.avatar_url).diskCacheStrategy(
                    DiskCacheStrategy.AUTOMATIC
                ).into(Image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListHolder {
        val binding= ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserListHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UserListHolder, position: Int) {
        holder.bind(list[position])
    }

    fun addData(user: List<UsersItem>) {
        Log.d("RESULT", "$user")
        this.list.apply{
            clear()
            addData(user)
        }
    }
}
