package com.example.chattingapp.data.model

data class Message(
    val userNo : Int,
    val roomNo : Int,
    val content : String,
    val sendTime : String,
    val sendDate : String
)