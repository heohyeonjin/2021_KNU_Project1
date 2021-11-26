package com.example.chattingapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
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

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    lateinit var navigationViewModel : NavigationViewModel
    lateinit var navigationViewModelFactory: NavigationViewModelFactory
    var corpNo : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)

        if (intent.hasExtra("corpNo")) {
            Log.d("Tag", "프로필 눌럿을 때 corpNo 값!!!!!!!!!!" + corpNo)
            corpNo = intent.getLongExtra("corpNo", 0L)

        } else {
            Toast.makeText(this, "전달된 이름이 없습니다", Toast.LENGTH_SHORT).show()
        }

        initViewModel()
    }

    private fun initViewModel(){
        navigationViewModelFactory = NavigationViewModelFactory()
        navigationViewModel = ViewModelProvider(this, navigationViewModelFactory).get(NavigationViewModel::class.java)
        binding.viewmodel = navigationViewModel
        binding.lifecycleOwner = this

        var enterButtonEvent = findViewById<Button>(R.id.button_enter_room)

        // 회사 프로필 정보 받아오기
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

        enterButtonEvent.setOnClickListener {
            ChatApiService.instance.getRoomNo(corpNo) {
                if(it != null) {
                    val intent = Intent(this, ChatActivity::class.java)
                    intent.putExtra("EnterDTO", it)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                }
                else {
                    val intent = Intent(this, ChatActivity::class.java)
                    startActivity(intent)
                }
            }
        }



    }
}