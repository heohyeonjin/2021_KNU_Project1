package com.example.chattingapp.ui.navigation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chattingapp.R
import com.example.chattingapp.adapter.ChatroomListAdapter
import com.example.chattingapp.adapter.CompanyAdapter
import com.example.chattingapp.data.model.ChatRoom
import com.example.chattingapp.data.model.Corporation

class ChattingListFragment : Fragment() {

    companion object {
        fun newInstance() : ChattingListFragment {
            return ChattingListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_chat_list, container, false)

        return view
    }

    var companyList = arrayListOf<Corporation>()
    private lateinit var listAdapter : ChatroomListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var list: ArrayList<ChatRoom> = requireActivity().intent!!.extras!!.get("chatRoomList") as ArrayList<ChatRoom>
        val companyView: RecyclerView = view.findViewById(R.id.fragment_chat_list_recyclerview)
        listAdapter = ChatroomListAdapter(list)
        companyView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        companyView.adapter = listAdapter


    }
}