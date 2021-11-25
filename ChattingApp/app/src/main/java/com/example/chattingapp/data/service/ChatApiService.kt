package com.example.chattingapp.data.service

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.chattingapp.data.model.*
import com.example.chattingapp.data.service.rest.RestApiService
import com.example.chattingapp.data.service.rest.RestApiServiceCallback
import java.util.function.Consumer

class ChatApiService(private val restApiService: RestApiService) {

    suspend fun sendChat(chat: Message) : String {
        return restApiService.sendChat(1L, chat)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun getChattingList(roomNo:Long, callback : Consumer<List<Chat>>){
        restApiService.getChattingList(roomNo).enqueue(RestApiServiceCallback(callback))
    }

    companion object{
        val instance = ChatApiService(RestApiService.instance)
    }
}
