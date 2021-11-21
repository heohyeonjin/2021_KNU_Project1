package com.example.chattingapp.data.model

data class Chat(
    val chatNo : Int,
    val userNo : Int,
    val roomNo : Int,
    val content : String,
    val sendTime : String,
    val sendDate : String,
    val writtenAt : String,
    val writtenBy : String,
    val type : Int
)