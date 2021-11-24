package com.example.chattingapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chattingapp.R
import com.example.chattingapp.data.model.ChatRoom
import com.example.chattingapp.data.model.Corporation

class ChatroomListAdapter (val chatroomList: ArrayList<ChatRoom>) :
    RecyclerView.Adapter<ChatroomListAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_company, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return chatroomList.size
    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(chatroomList[position],position)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val corpName = itemView?.findViewById<TextView>(R.id.company_name)



        fun bind(chatroom: ChatRoom, position:Int){
            corpName?.text = chatroom.corpName





        }
    }
}