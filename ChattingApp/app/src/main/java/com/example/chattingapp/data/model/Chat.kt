package com.example.chattingapp.data.model

data class Chat(
    val roomNo : Long,
    val content : String,
    val time : String,
    val date : String,
    val sender : Int
)