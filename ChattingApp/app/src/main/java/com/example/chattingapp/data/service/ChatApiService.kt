package com.example.chattingapp.data.service

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.chattingapp.data.model.*
import com.example.chattingapp.data.service.rest.RestApiService
import com.example.chattingapp.data.service.rest.RestApiServiceCallback
import java.util.function.Consumer

class ChatApiService(private val restApiService: RestApiService) {

    suspend fun sendChat(corpNo: Long, chat: Message) : Long {
        return restApiService.sendChat(corpNo, chat)
    }

    fun getChatList(roomNo:Long, callback : Consumer<List<Chat>>){
        restApiService.getChatList(roomNo).enqueue(RestApiServiceCallback(callback))
    }

    fun getRoomNo(corpNo: Long, callback : Consumer<EnterDTO>) {
        restApiService.getRoomNo(corpNo).enqueue(RestApiServiceCallback(callback))
    }

    fun getChatRoomList(callback : Consumer<List<RoomDTO>>) {
        restApiService.getChatRoomList().enqueue(RestApiServiceCallback(callback))
    }

    companion object{
        val instance = ChatApiService(RestApiService.instance)
    }
}
