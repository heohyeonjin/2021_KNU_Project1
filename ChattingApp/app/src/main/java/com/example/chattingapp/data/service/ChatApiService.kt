package com.example.chattingapp.data.service

import com.example.chattingapp.data.model.*
import com.example.chattingapp.data.service.rest.RestApiService

class ChatApiService(private val restApiService: RestApiService) {

    suspend fun sendChat(chat: Message) : String {
        return restApiService.sendChat(1L, chat)
    }

    companion object{
        val instance = ChatApiService(RestApiService.instance)
    }
}
