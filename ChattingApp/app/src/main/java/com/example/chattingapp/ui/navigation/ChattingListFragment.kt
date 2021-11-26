package com.example.chattingapp.ui.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chattingapp.R
import com.example.chattingapp.adapter.ChatRoomAdapter
import com.example.chattingapp.adapter.ChatRoomListAdapter
import com.example.chattingapp.data.model.RoomDTO
import com.example.chattingapp.data.service.ChatApiService
import com.example.chattingapp.data.service.CompanyApiService
import com.example.chattingapp.databinding.FragmentChatListBinding

class ChattingListFragment : Fragment() {

    companion object {
        fun newInstance() : ChattingListFragment {
            return ChattingListFragment()
        }
    }

    var chatRoomList = ArrayList<RoomDTO>()
    private lateinit var chatRoomListAdapter : ChatRoomListAdapter
    private lateinit var chatRoomListRecyclerView: RecyclerView
    private lateinit var binding: FragmentChatListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat_list, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        chatRoomListAdapter = ChatRoomListAdapter(chatRoomList)
        chatRoomListRecyclerView = view.findViewById(R.id.fragment_chat_list_recyclerview)
        chatRoomListRecyclerView.adapter = chatRoomListAdapter
        chatRoomListRecyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        chatRoomListRecyclerView.setHasFixedSize(true)

        ChatApiService.instance.getChatRoomList(){
            for(room in it) {
                chatRoomListAdapter.setChatList(room)
            }
        }
    }
}