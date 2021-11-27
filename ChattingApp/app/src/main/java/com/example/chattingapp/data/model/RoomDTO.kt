package com.example.chattingapp.data.model

data class RoomDTO(
    var roomNo : Long,
    var corpName : String,
    var content : String,
    var time : String,
    var clientRead : Int, //1이면 읽음 0이면 안읽음
    var corpNo : String
)