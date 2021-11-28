package com.example.chattingapp.ui.navigation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chattingapp.ProfileActivity
import com.example.chattingapp.R
import com.example.chattingapp.adapter.ChatRoomAdapter
import com.example.chattingapp.adapter.ChatRoomListAdapter
import com.example.chattingapp.adapter.CompanyAdapter
import com.example.chattingapp.data.model.EnterDTO
import com.example.chattingapp.data.model.RoomDTO
import com.example.chattingapp.data.service.ChatApiService
import com.example.chattingapp.data.service.CompanyApiService
import com.example.chattingapp.databinding.FragmentChatListBinding
import com.example.chattingapp.ui.ChatActivity

class ChattingListFragment : Fragment() {

    companion object {
        fun newInstance() : ChattingListFragment {
            return ChattingListFragment()
        }
    }

    var chatRoomList = ArrayList<RoomDTO>()
    lateinit var chatRoomListAdapter : ChatRoomListAdapter
    lateinit var chatRoomListRecyclerView: RecyclerView
    lateinit var binding: FragmentChatListBinding

    override fun onResume() {
        super.onResume()

        ChatApiService.instance.getChatRoomList(){
            chatRoomListAdapter.chatroomList.clear()
            for(room in it) {
                chatRoomListAdapter.setChatList(room)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat_list, container, false)

//        onResume()

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
            chatRoomListAdapter.chatroomList.clear()
            for(room in it) {
                chatRoomListAdapter.setChatList(room)
            }
        }

        // 채팅방 클릭 시 이벤트
        chatRoomListAdapter.setItemClickListener(object: ChatRoomListAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                var clickRoomEnterDTO = EnterDTO("${chatRoomList[position].roomNo}".toLong(), "${chatRoomList[position].corpName}", "${chatRoomList[position].corpNo}".toLong())

                Log.d("Tag", "클릭 채팅방!!!!!! : " + clickRoomEnterDTO.roomNo + clickRoomEnterDTO.corpName)

                // 클릭한 채팅방의 roomNoActivity로 넘겨줌
                val intent = Intent(activity, ChatActivity::class.java)
                intent.putExtra("EnterDTO", clickRoomEnterDTO)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        })
    }

}