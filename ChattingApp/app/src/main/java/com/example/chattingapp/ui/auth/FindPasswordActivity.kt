package com.example.chattingapp.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chattingapp.databinding.ActivityFindPasswordBinding

class FindPasswordActivity : AppCompatActivity() {

    val binding by lazy { ActivityFindPasswordBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        binding.buttonCertify.setOnClickListener {
//            val intent = Intent(this, FindPasswordVerifyActivity::class.java)
//            startActivity(intent)
//        }
    }
}