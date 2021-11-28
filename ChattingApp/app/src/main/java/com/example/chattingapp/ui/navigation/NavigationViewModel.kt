package com.example.chattingapp.ui.navigation

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chattingapp.data.model.CompanyProfile
import com.example.chattingapp.data.model.EnterDTO
import com.example.chattingapp.data.model.Message
import com.example.chattingapp.data.service.ChatApiService
import com.example.chattingapp.data.service.CompanyApiService
import com.example.chattingapp.utils.NetworkStatus
import kotlinx.coroutines.launch

class NavigationViewModel() : ViewModel() {

    var corpNo = 0L

}