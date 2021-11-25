package com.example.chattingapp.ui.chat

import com.example.chattingapp.ui.auth.AuthListener
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chattingapp.R
import com.example.chattingapp.utils.MyApplication
import com.example.chattingapp.utils.NetworkStatus
import androidx.lifecycle.viewModelScope
import com.example.chattingapp.data.model.*
import com.example.chattingapp.data.service.ChatApiService
import com.example.chattingapp.data.service.UserApiService
import kotlinx.coroutines.launch

class ChatViewModel() : ViewModel() {

    //chat field
    var sendContent = ObservableField<String>()
    var sendMsgType = 1

    //채팅 보내기
    private val _getResponse : MutableLiveData<String> = MutableLiveData()
    val getResponse : LiveData<String> get() = _getResponse

    fun sendChatting() = viewModelScope.launch {
        if(NetworkStatus.status){
            Log.d("sendChat","채팅 감")
            _getResponse.value = ChatApiService.instance.sendChat(Message(sendContent.get()!!, 1))
            Log.d("receiveError", "리턴 값 " + _getResponse.value)
        }
    }

    // 채팅 필드 확인
    fun checkChatField(){
        if(sendContent.get().isNullOrEmpty()){
            return
        }

        sendChatting()
    }


}