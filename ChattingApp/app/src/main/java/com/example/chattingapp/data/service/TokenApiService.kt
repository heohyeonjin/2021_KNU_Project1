package com.example.chattingapp.data.service

import com.example.chattingapp.data.model.SignInForm
import com.example.chattingapp.data.model.SignUpForm
import com.example.chattingapp.data.service.rest.RestApiService

class TokenApiService(private val restApiService: RestApiService) {

    suspend fun getToken(sendToken:String) : String{
        return restApiService.getToken(sendToken)
    }

    companion object{
        val instance = TokenApiService(RestApiService.instance)
    }
}
