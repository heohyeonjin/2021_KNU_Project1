package com.example.chattingapp.ui.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NavigationViewModelFactory() : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NavigationViewModel() as T
    }
}