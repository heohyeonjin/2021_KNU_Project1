package com.example.chattingapp.data.service.rest

import com.example.chattingapp.data.model.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RestApiService {
    // User
    @POST("/api/signup") suspend fun signUp(@Body signUpForm: SignUpForm) : String
    @POST("/api/login") suspend fun login(@Body signInForm: SignInForm) : SignUpForm
    @POST("/api/check") suspend fun requestEmailCheck(@Body signUpEmail : EmailDTO) : String

    // Chatting
    @POST("/api/message/{corpNo}") suspend fun sendChat(@Path("corpNo") corpNo: Long, @Body chat: Message) : String

    // Token
    @POST("/getToken") suspend fun sendFirebaseToken(@Body sendToken: TokenDTO) : String

    companion object {
        val instance = RestApiServiceGenerator.createService(RestApiService::class.java)
    }
}