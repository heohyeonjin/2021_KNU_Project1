package com.example.chattingapp.ui.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chattingapp.ui.chat.ChatViewModel

class ChatViewModelFactory() : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ChatViewModel() as T
    }
}