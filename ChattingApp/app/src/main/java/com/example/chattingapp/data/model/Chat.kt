package com.example.chattingapp.data.model

data class Chat(
    var content : String,
    var date : String,
    var time : String,
    var sender : Int //0 상담사, 1 고객
)