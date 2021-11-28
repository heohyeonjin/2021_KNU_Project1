package com.example.chattingapp.data.service

import com.example.chattingapp.data.model.*
import com.example.chattingapp.data.service.rest.RestApiService
import com.example.chattingapp.data.service.rest.RestApiServiceCallback
import java.util.function.Consumer

class UserApiService(private val restApiService: RestApiService) {

    suspend fun requestEmailCheck(signUpEmail: EmailDTO) : String {
        return restApiService.requestEmailCheck(signUpEmail)
    }

    suspend fun signUp(signUpForm: SignUpForm) : String {
        return restApiService.signUp(signUpForm)
    }

    suspend fun login(signInForm: SignInForm) : String {
        return restApiService.login(signInForm)
    }

    fun getMyPage(callback : Consumer<MyPageDTO>) {
        restApiService.getMyPage().enqueue(RestApiServiceCallback(callback))
    }

    companion object{
        val instance = UserApiService(RestApiService.instance)
    }
}
