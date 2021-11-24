package com.example.chattingapp.data.model

import com.google.gson.annotations.SerializedName

data class ApiError(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int
)
