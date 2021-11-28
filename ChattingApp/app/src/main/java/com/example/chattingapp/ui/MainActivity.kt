package com.example.chattingapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.ArrayRes
import androidx.databinding.DataBindingUtil
import com.example.chattingapp.R
import com.example.chattingapp.data.model.ChatRoom
import com.example.chattingapp.data.model.Corporation
import com.example.chattingapp.databinding.ActivityMainBinding
import com.example.chattingapp.ui.navigation.ChattingListFragment
import com.example.chattingapp.ui.navigation.CompanyListFragment
import com.example.chattingapp.ui.navigation.MypageFragment
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    private lateinit var binding: ActivityMainBinding
    private lateinit var chatListFragment: ChattingListFragment
    private lateinit var companyListFragment: CompanyListFragment
    private lateinit var mypageFragment: MypageFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.bottomNavigation.apply {
            setOnItemSelectedListener {
//                Log.d("프래그먼트 id : ", "흠냐 = " + it.itemId)
                when(it.itemId){
                    R.id.action_company_list -> {
                        companyListFragment = CompanyListFragment.newInstance()
                        supportFragmentManager.beginTransaction().replace(R.id.main_content, companyListFragment).commit()
                        return@setOnItemSelectedListener true
                    }

                    R.id.action_chatting -> {
                        chatListFragment = ChattingListFragment.newInstance()
                        supportFragmentManager.beginTransaction().replace(R.id.main_content, chatListFragment).commit()
                        return@setOnItemSelectedListener true
                    }

                    R.id.action_my_page -> {
                        mypageFragment = MypageFragment.newInstance()
                        supportFragmentManager.beginTransaction().replace(R.id.main_content, mypageFragment).commit()
                        return@setOnItemSelectedListener true
                    }
                }
                false
            }
        }

        binding.bottomNavigation.selectedItemId = R.id.action_company_list

    }

}
