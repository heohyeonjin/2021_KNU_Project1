package com.example.chattingapp.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SignUpForm(
    val email : String,
    val password : String,
    val name : String,
    val gender : Int,
    val tel : String
) : Parcelable