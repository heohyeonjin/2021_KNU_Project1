package com.example.chattingapp.data.service

import com.example.chattingapp.data.model.TokenDTO
import com.example.chattingapp.data.service.rest.RestApiService

class TokenApiService(private val restApiService: RestApiService) {

    suspend fun sendFirebaseToken(sendToken : TokenDTO) : String{
        return restApiService.sendFirebaseToken(sendToken)
    }

    companion object{
        val instance = TokenApiService(RestApiService.instance)
    }
}