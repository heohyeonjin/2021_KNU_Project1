package com.example.chattingapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
    var companyList: ArrayList<Corporation> = arrayListOf(
        Corporation(1,"samsung","company","company"),
        Corporation(2,"LG","company","company")
    )

    var chatroomList: ArrayList<ChatRoom> = arrayListOf(
        ChatRoom(1,"samsung","hi","2021.11.11")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.bottomNavigation.apply {
            setOnItemSelectedListener {
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

        val transaction_company = supportFragmentManager.beginTransaction()
        transaction_company.replace(
            R.id.main_content,
            CompanyListFragment()
        )
        transaction_company.commit()
        intent.putExtra("companyList",companyList)

        val transaction_chatroom = supportFragmentManager.beginTransaction()
        transaction_chatroom.replace(
            R.id.main_content,
            CompanyListFragment()
        )
        transaction_chatroom.commit()
        intent.putExtra("chatRoomList",chatroomList)

        getFcm_Token()
    }




    fun getFcm_Token(){
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result

            val msg = getString(R.string.msg_token_fmt, token)
            Log.d(TAG, msg)
            Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
        })
    }






}
