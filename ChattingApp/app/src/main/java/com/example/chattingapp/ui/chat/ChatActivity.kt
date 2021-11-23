package com.example.chattingapp.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chattingapp.R
import com.example.chattingapp.adapter.ChatRoomAdapter
import com.example.chattingapp.data.model.Chat
import com.example.chattingapp.data.model.User

class ChatActivity : AppCompatActivity() {

    lateinit var viewAdapter : ChatRoomAdapter
    val datas = mutableListOf<Chat>()
    private lateinit var ChatActivityRecycleview : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        initRecycler()
    }

    private fun initRecycler() {
        var user = User(1, "email", "aaa", "name", 1, "000", 1)
        viewAdapter = ChatRoomAdapter(user)

        datas.add(Chat(1, 1, 1, "hi", "10:10","2021-01-01", "corp A", "A", 2))
        datas.add(Chat(2, 1, 1, "hi", "10:10","2021-01-01", "corp A", "corp A", 1))

        viewAdapter.setMessages(datas)

        ChatActivityRecycleview = findViewById(R.id.chat_content)

        ChatActivityRecycleview.adapter = viewAdapter
//        ChatActivityRecycleview.layoutManager= LinearLayoutManager(applicationContext)
//        ChatActivityRecycleview.setHasFixedSize(true)
    }

//    fun dataChangeAndScrollToEnd(messages: List<Chat>) {
//        viewAdapter.setMessages(messages)
//        if(viewAdapter.itemCount > 0)
//            ChatActivityRecycleview.smoothScrollToPosition(viewAdapter.itemCount - 1)
//    }
}