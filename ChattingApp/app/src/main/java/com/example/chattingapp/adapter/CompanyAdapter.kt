package com.example.chattingapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chattingapp.R
import com.example.chattingapp.data.model.Company
import com.example.chattingapp.data.model.Corporation

class CompanyAdapter (val companyList: ArrayList<Company>) :
    RecyclerView.Adapter<CompanyAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_company, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return companyList.size
    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(companyList[position],position)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){

//        val corpLogo = itemView?.findViewById<ImageView>(R.id.companyImg)
        val corpName = itemView?.findViewById<TextView>(R.id.company_name)
        val corpAdmin = itemView?.findViewById<TextView>(R.id.company_introduce)



        fun bind(corp: Company, position:Int){
//            Glide.with(itemView).load(corp.corpLogo).into(corpLogo)
            corpName?.text = corp.corpName
            corpAdmin?.text = corp.corpAdmin


        }
    }

    fun setCompany(item : Company){
        companyList.add(item)
        notifyDataSetChanged()
    }
}