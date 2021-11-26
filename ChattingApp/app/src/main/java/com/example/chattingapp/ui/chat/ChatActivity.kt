package com.example.chattingapp.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chattingapp.R
import com.example.chattingapp.adapter.ChatRoomAdapter
import com.example.chattingapp.data.model.Chat
import com.example.chattingapp.data.model.EnterDTO
import com.example.chattingapp.data.model.User
import com.example.chattingapp.data.service.ChatApiService
import com.example.chattingapp.databinding.ActivityChatBinding
import com.example.chattingapp.ui.auth.ViewModelFactory
import com.example.chattingapp.ui.chat.ChatViewModel
import com.example.chattingapp.ui.chat.ChatViewModelFactory
import com.example.chattingapp.utils.NetworkConnection
import com.example.chattingapp.utils.NetworkStatus
import com.example.chattingapp.utils.toast
import org.w3c.dom.Text

class ChatActivity : AppCompatActivity() {

    lateinit var viewAdapter : ChatRoomAdapter
    val datas = ArrayList<Chat>()
    private lateinit var ChatActivityRecycleview : RecyclerView
    private lateinit var binding: ActivityChatBinding
    lateinit var viewModel : ChatViewModel
    lateinit var chatViewModelFactory: ChatViewModelFactory
    lateinit var enterDTO : EnterDTO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chat)
        var chatCompanyName = findViewById<TextView>(R.id.chat_name)

        val connection = NetworkConnection(applicationContext)
        connection.observe(this){ isConnected ->
            if (isConnected) NetworkStatus.status = true
            else NetworkStatus.status = false
        }

        //초기화
        enterDTO = EnterDTO(0L, "")

        if (intent.hasExtra("EnterDTO")) {
            enterDTO = intent.getParcelableExtra("EnterDTO")!!
            chatCompanyName?.text = enterDTO.corpName
            Log.d("채팅방 들어옴", "enterDTO.corpName & roomNo = " + enterDTO.corpName + enterDTO.roomNo)
        }

        viewAdapter = ChatRoomAdapter(datas, chatCompanyName.text.toString())

        ChatActivityRecycleview = findViewById(R.id.chat_content)
        ChatActivityRecycleview.adapter = viewAdapter
        ChatActivityRecycleview.layoutManager= LinearLayoutManager(applicationContext)
        ChatActivityRecycleview.setHasFixedSize(true)

        dataChangeAndScrollToEnd(datas)

        initViewModel()
    }


    private fun initViewModel(){
        chatViewModelFactory = ChatViewModelFactory()
        viewModel = ViewModelProvider(this, chatViewModelFactory).get(ChatViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        // 채팅 전송
        viewModel.getResponse.observe(this) {
            if (it.equals("true")) { //채팅 전송 성공
                ChatApiService.instance.getChatList(enterDTO.roomNo) {
//                    viewAdapter.setMessages(it)
                    dataChangeAndScrollToEnd(it)
                }
            }
        }


    }

    fun dataChangeAndScrollToEnd(messages: List<Chat>) {
        viewAdapter.setMessages(messages)
        if(viewAdapter.itemCount > 0)
            ChatActivityRecycleview.smoothScrollToPosition(viewAdapter.itemCount - 1)
    }
}