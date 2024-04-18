package com.example.finalapp.data.model

import com.google.gson.annotations.SerializedName

data class UsersItem(
    @SerializedName("image")
    val avatar_url: String,
    @SerializedName("login")
    val login: String,
)