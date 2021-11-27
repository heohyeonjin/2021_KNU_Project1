package com.example.chattingapp.adapter


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chattingapp.R
import com.example.chattingapp.data.model.Chat
import com.example.chattingapp.data.model.SignUpForm
import com.example.chattingapp.data.model.User
import com.example.chattingapp.databinding.DetailDateBinding
import com.example.chattingapp.databinding.DetailReceiveMsgBinding
import com.example.chattingapp.databinding.DetailSendMsgBinding
import java.lang.RuntimeException


class ChatRoomAdapter(val lst: ArrayList<Chat>, val chatCompanyName: String) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    val lst = mutableListOf<Chat>()
    val messageIdToIdx = HashMap<Int, Int>()

    val CENTER_POSITION = 0   // 날짜
    val LEFT_POSITION = 1     // 상담원 메세지
    val RIGHT_POSITION = 2    // 내 메세지

    private lateinit var dateBinding: DetailDateBinding      // center
    private lateinit var receiveBinding: DetailReceiveMsgBinding // left
    private lateinit var sendBinding: DetailSendMsgBinding // right

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {


        return when(viewType) {
//            CENTER_POSITION -> {
//                dateBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.detail_date, parent, false)
//                CenterViewHolder(dateBinding)
//            }
            LEFT_POSITION -> {
                receiveBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.detail_receive_msg, parent, false)
                LeftViewHolder(receiveBinding)
            }
            RIGHT_POSITION -> {
                sendBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.detail_send_msg, parent, false)
                RightViewHolder(sendBinding)
            }
            else -> {
                throw RuntimeException("알 수 없는 viewtype error")
            }
        }

    }

    override fun getItemCount(): Int {
        return lst.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is LeftViewHolder) {

            if (position == 0) {
                holder.binding.textGchatDateLeft.visibility = View.VISIBLE
                holder.binding.textGchatDateLeft.text = lst[position].date
                holder.binding.textGchatMessageOther.text = lst[position].content
                holder.binding.textGchatTimestampOther.text = lst[position].time
                holder.binding.textGchatUserOther.text = chatCompanyName
            } else {
                if (lst[position].date.equals(lst[position - 1].date)) {
                    holder.binding.textGchatDateLeft.visibility = View.GONE
                    holder.binding.textGchatMessageOther.text = lst[position].content
                    holder.binding.textGchatTimestampOther.text = lst[position].time
                    holder.binding.textGchatUserOther.text = chatCompanyName
                } else {
                    holder.binding.textGchatDateLeft.visibility = View.VISIBLE
                    holder.binding.textGchatDateLeft.text = lst[position].date
                    holder.binding.textGchatMessageOther.text = lst[position].content
                    holder.binding.textGchatTimestampOther.text = lst[position].time
                    holder.binding.textGchatUserOther.text = chatCompanyName
                }
            }
        } else if (holder is RightViewHolder) {
            if (position == 0) {
                holder.binding.textGchatDateRight.visibility = View.VISIBLE
                holder.binding.textGchatDateRight.text = lst[position].date
                holder.binding.textGchatSendMassage.text = lst[position].content
                holder.binding.textGchatSendTime.text = lst[position].time
            } else {
                if (lst[position].date.equals(lst[position - 1].date)) {
                    holder.binding.textGchatDateRight.visibility = View.GONE
                    holder.binding.textGchatSendMassage.text = lst[position].content
                    holder.binding.textGchatSendTime.text = lst[position].time
                } else {
                    holder.binding.textGchatDateRight.visibility = View.VISIBLE
                    holder.binding.textGchatDateRight.text = lst[position].date
                    holder.binding.textGchatSendMassage.text = lst[position].content
                    holder.binding.textGchatSendTime.text = lst[position].time
                }
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int,payloads: MutableList<Any>) {
        if(payloads.isEmpty()){
            onBindViewHolder(holder,position)
            return
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (lst[position].sender == 1) {
            return RIGHT_POSITION
        }
        return LEFT_POSITION
    }

    inner class CenterViewHolder(val binding : DetailDateBinding) : RecyclerView.ViewHolder(binding.root){ }
    inner class LeftViewHolder(val binding : DetailReceiveMsgBinding) : RecyclerView.ViewHolder(binding.root){ }
    inner class RightViewHolder(val binding : DetailSendMsgBinding) : RecyclerView.ViewHolder(binding.root){ }

    fun setMessages(messages: List<Chat>) {
        this.lst.clear()
        this.lst.addAll(messages)
        notifyDataSetChanged()
    }

}