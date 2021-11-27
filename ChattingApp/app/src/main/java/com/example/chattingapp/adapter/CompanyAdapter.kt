package com.example.chattingapp.adapter

import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chattingapp.R
import com.example.chattingapp.data.model.Company
import com.example.chattingapp.data.model.Corporation

class CompanyAdapter (val companyList: ArrayList<Company>) :
    RecyclerView.Adapter<CompanyAdapter.Holder>() {

    private lateinit var itemClickListener : OnItemClickListener
    // 리사이클러 뷰에 아이템 클릭 시 이벤트 처리
    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }

    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_company, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return companyList.size
    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(companyList[position],position)

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){

//        val corpLogo = itemView?.findViewById<ImageView>(R.id.companyImg)
        val corpName = itemView?.findViewById<TextView>(R.id.company_name)
        val corpDesc = itemView?.findViewById<TextView>(R.id.company_introduce)

        fun bind(corp: Company, position:Int){
            corpName?.text = corp.corpName
            corpDesc?.text = corp.corpDesc
        }
    }

    fun setCompany(item : Company){
        companyList.add(item)
        notifyDataSetChanged()
    }

}