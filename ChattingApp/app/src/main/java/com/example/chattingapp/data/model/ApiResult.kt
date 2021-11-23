package com.example.chattingapp.data.model

import com.google.gson.annotations.SerializedName

data class ApiResult<T>(
    @SerializedName("error")
    val error: ApiError,
    @SerializedName("response")
    val response: T,
    @SerializedName("success")
    val success: Boolean
)