package com.example.chattingapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Corporation(
    val corpNo : Int,
    val corpName : String,
    val corpDesc : String,
    val corpLogo : String
) : Parcelable