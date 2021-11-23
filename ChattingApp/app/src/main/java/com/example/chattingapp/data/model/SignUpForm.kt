package com.example.chattingapp.data.model

data class SignUpForm(
    val email : String,
    val password : String,
    val name : String,
    val gender : Int,
    val tel : String,
    val birth : Int
)