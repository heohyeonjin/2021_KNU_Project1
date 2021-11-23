package com.example.chattingapp.data.service

import com.example.chattingapp.data.model.ApiResult
import com.example.chattingapp.data.model.SignInForm
import com.example.chattingapp.data.model.SignUpForm
import com.example.chattingapp.data.service.rest.RestApiService

class UserApiService(private val restApiService: RestApiService) {

    suspend fun signUp(signUpForm: SignUpForm) : String {
        return restApiService.signUp(signUpForm)
    }

    suspend fun login(signInForm: SignInForm) : SignUpForm {
        return restApiService.login(signInForm)
    }

    companion object{
        val instance = UserApiService(RestApiService.instance)
    }
}
