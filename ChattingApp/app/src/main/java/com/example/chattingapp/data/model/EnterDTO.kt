package com.example.chattingapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EnterDTO(
    var roomNo : Long,
    var corpName : String
) : Parcelable