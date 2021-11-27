package com.example.chattingapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chattingapp.R
import com.example.chattingapp.data.model.ChatRoom
import com.example.chattingapp.data.model.Company
import com.example.chattingapp.data.model.RoomDTO

class ChatRoomListAdapter (val chatroomList: ArrayList<RoomDTO>) :
    RecyclerView.Adapter<ChatRoomListAdapter.Holder>(){

    private lateinit var itemClickListener : OnItemClickListener
    // 리사이클러 뷰에 아이템 클릭 시 이벤트 처리
    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }

    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chattroomlist, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return chatroomList.size
    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(chatroomList[position],position)

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val corpName = itemView?.findViewById<TextView>(R.id.chat_company_name)
        val content = itemView?.findViewById<TextView>(R.id.current_msg)
        val time = itemView?.findViewById<TextView>(R.id.currebt_time)
        val clientRead = itemView?.findViewById<TextView>(R.id.new_msg)


        fun bind(chatroom: RoomDTO, position:Int){
            corpName?.text = chatroom.corpName
            content?.text = chatroom.content
            time?.text = chatroom.time
            if (chatroom.clientRead == 0) {
                clientRead?.text = "new"
            }
        }
    }

    fun setChatList(item : RoomDTO){
        chatroomList.add(item)
        notifyDataSetChanged()
    }
}