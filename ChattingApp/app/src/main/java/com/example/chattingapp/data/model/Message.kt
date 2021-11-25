package com.example.chattingapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Message(
    val content : String,
    val type : Int
) : Parcelable