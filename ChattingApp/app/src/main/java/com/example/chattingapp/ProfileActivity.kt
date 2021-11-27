package com.example.chattingapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.chattingapp.adapter.ChatRoomAdapter
import com.example.chattingapp.data.model.Chat
import com.example.chattingapp.data.service.ChatApiService
import com.example.chattingapp.data.service.CompanyApiService
import com.example.chattingapp.databinding.ActivityChatBinding
import com.example.chattingapp.databinding.ActivityMainBinding
import com.example.chattingapp.databinding.ActivityProfileBinding
import com.example.chattingapp.ui.ChatActivity
import com.example.chattingapp.ui.chat.ChatViewModel
import com.example.chattingapp.ui.chat.ChatViewModelFactory
import com.example.chattingapp.ui.navigation.NavigationViewModel
import com.example.chattingapp.ui.navigation.NavigationViewModelFactory
import com.example.chattingapp.utils.NetworkConnection
import com.example.chattingapp.utils.NetworkStatus

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    lateinit var navigationViewModel : NavigationViewModel
    lateinit var navigationViewModelFactory: NavigationViewModelFactory
    var corpNo : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        var enterButtonEvent = findViewById<Button>(R.id.button_enter_room)
        var endButton = findViewById<ImageButton>(R.id.imageButton2)

        val connection = NetworkConnection(applicationContext)
        connection.observe(this){ isConnected ->
            if (isConnected) NetworkStatus.status = true
            else NetworkStatus.status = false
        }

        if (intent.hasExtra("corpNo")) {
            // 잘 넘어옴
            corpNo = intent.getLongExtra("corpNo", 0L)
        } else {
            Toast.makeText(this, "전달된 이름이 없습니다", Toast.LENGTH_SHORT).show()
        }

        initViewModel()

        enterButtonEvent.setOnClickListener {
            Log.d("버튼 클릭", "enter room 버튼 눌림!!!!!!!!!!!, corpNo : " + corpNo)


            ChatApiService.instance.getRoomNo(corpNo) {
                Log.d("getRoomNo", "corpName : " + it.corpName + ", roomNo : " + it.roomNo + ", corpNo : " + it.corpNo)
                val intent = Intent(this, ChatActivity::class.java)
                intent.putExtra("EnterDTO", it)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        }

        // 닫기 버튼 눌렀을 때
        endButton.setOnClickListener {
            finish()
        }
    }

    private fun initViewModel(){
        navigationViewModelFactory = NavigationViewModelFactory()
        navigationViewModel = ViewModelProvider(this, navigationViewModelFactory).get(NavigationViewModel::class.java)
        binding.viewmodel = navigationViewModel
        binding.lifecycleOwner = this



        // 회사 프로필 정보 받아오기 (잘 뜸)
        CompanyApiService.instance.getCompanyProfile(corpNo) {
            var profileCorpName = findViewById<TextView>(R.id.profile_company_name)
            var profileCorpDesc = findViewById<TextView>(R.id.profile_company_desc)
            var profileCorpAdmin = findViewById<TextView>(R.id.profile_company_admin)
            var profileCorpEmail = findViewById<TextView>(R.id.profile_company_email)
            var profileCorpTel = findViewById<TextView>(R.id.profile_company_tel)

            profileCorpName?.text = it.corpName
            profileCorpDesc?.text = it.corpDesc
            profileCorpAdmin?.text = it.corpAdmin
            profileCorpEmail?.text = it.corpEmail
            profileCorpTel?.text = it.corpTel
        }
    }
}