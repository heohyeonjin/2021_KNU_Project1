package com.example.chattingapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.chattingapp.data.model.Corporation
import com.example.chattingapp.databinding.ActivityMainBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        val intent : Intent = getIntent()
        var list: Corporation = intent.getParcelableExtra("corporation")!!


    }
}
