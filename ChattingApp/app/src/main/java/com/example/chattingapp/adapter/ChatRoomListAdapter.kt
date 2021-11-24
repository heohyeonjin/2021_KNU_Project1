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

class ChatRoomListAdapter (val ChatRoom :ArrayList<ChatRoom>)
    :RecyclerView.Adapter<ChatRoomListAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chatroomlist, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return ChatRoom.size
    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(ChatRoom[position],position)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val corpLogo = itemView?.findViewById<ImageView>(R.id.companyImg)
        val corpDesc = itemView?.findViewById<TextView>(R.id.company_introduce)
        val corpName = itemView?.findViewById<TextView>(R.id.item_chatroomlist.xml)



        fun bind(chatroom: Chatroom, position:Int){
            Glide.with(itemView).load(corp.corpLogo).into(corpLogo)
            corpName?.text = corp.corpName
            corpDesc?.text = corp.corpDesc
        }
    }






}

