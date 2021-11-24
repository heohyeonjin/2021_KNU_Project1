package com.example.chattingapp.data.service.rest

import com.example.chattingapp.data.model.ApiResult
import com.example.chattingapp.data.model.SignInForm
import com.example.chattingapp.data.model.SignUpForm
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RestApiService {
    // User
    @POST("/api/signup") suspend fun signUp(@Body signUpForm: SignUpForm) : String
    @POST("/api/login") suspend fun login(@Body signInForm: SignInForm) : SignUpForm

    companion object {
        val instance = RestApiServiceGenerator.createService(RestApiService::class.java)
    }
}