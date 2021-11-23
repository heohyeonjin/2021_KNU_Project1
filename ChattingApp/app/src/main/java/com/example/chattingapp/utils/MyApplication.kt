package com.example.chattingapp.utils

import android.app.Application
import android.content.Context

class MyApplication : Application() {
    companion object {
        lateinit var prefs: MySharedPreferences
        lateinit var instance: MyApplication
            private set
    }

    override fun onCreate() {
        prefs = MySharedPreferences(applicationContext)
        super.onCreate()
        instance = this
    }

    fun context() : Context = applicationContext
}