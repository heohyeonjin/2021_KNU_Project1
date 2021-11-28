package com.example.chattingapp.data.service.rest

import com.example.chattingapp.data.model.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.Call

interface RestApiService {
    // User
    @POST("/api/signup") suspend fun signUp(@Body signUpForm: SignUpForm) : String
    @POST("/api/login") suspend fun login(@Body signInForm: SignInForm) : String
    @POST("/api/check") suspend fun requestEmailCheck(@Body signUpEmail : EmailDTO) : String

    // Chatting
    @POST("/api/message/{corpNo}") suspend fun sendChat(@Path("corpNo") corpNo: Long, @Body chat: Message) : Long
    @GET("/api/messages/{roomNo}") fun getChatList(@Path("roomNo") roomNo: Long) : Call<List<Chat>>
    @GET("/api/rooms") fun getChatRoomList() :  Call<List<RoomDTO>>
    @GET("/api/corporation/enter/{corpNo}") fun getRoomNo(@Path("corpNo") corpNo: Long) : Call<EnterDTO>

    // Token
    @POST("/getToken") suspend fun sendFirebaseToken(@Body sendToken: TokenDTO) : String

    // Company
    @GET("/api/corporations") fun getCompanyList() : Call<List<Company>>
    @GET("/api/corporation/{corpNo}") fun getCompanyProfile(@Path("corpNo") corpNo : Long) : Call<CompanyProfile>

    // MyPage
    @GET("/api/mypage") fun getMyPage() : Call<MyPageDTO>


    companion object {
        val instance = RestApiServiceGenerator.createService(RestApiService::class.java)
    }
}