package com.example.chattingapp.ui.navigation

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chattingapp.ProfileActivity
import com.example.chattingapp.R
import com.example.chattingapp.adapter.ChatRoomAdapter
import com.example.chattingapp.adapter.CompanyAdapter
import com.example.chattingapp.data.model.Chat
import com.example.chattingapp.data.model.Company
import com.example.chattingapp.data.model.Corporation
import com.example.chattingapp.data.model.User
import com.example.chattingapp.data.service.CompanyApiService
import com.example.chattingapp.databinding.ActivityChatBinding
import com.example.chattingapp.databinding.FragmentCompanyListBinding
import com.example.chattingapp.ui.chat.ChatViewModel
import com.example.chattingapp.ui.chat.ChatViewModelFactory
import com.example.chattingapp.utils.NetworkConnection
import com.example.chattingapp.utils.NetworkStatus

class CompanyListFragment : Fragment() {

    companion object {
        fun newInstance() : CompanyListFragment {
            return CompanyListFragment()
        }
    }

    var companyList = ArrayList<Company>()
    private lateinit var companyAdapter : CompanyAdapter
    private lateinit var companyRecyclerView: RecyclerView
    private lateinit var binding: FragmentCompanyListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_company_list, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       
        companyAdapter = CompanyAdapter(companyList)
        companyRecyclerView = view.findViewById(R.id.fragment_company_list_recyclerview)
        companyRecyclerView.adapter = companyAdapter
        companyRecyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        companyRecyclerView.setHasFixedSize(true)

        CompanyApiService.instance.getCompanyList(){
            for(company in it) {
                companyAdapter.setCompany(company)
            }
        }

        // 회사 클릭 시 이벤트
        companyAdapter.setItemClickListener(object: CompanyAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                Log.d("Tag", "클릭 회사!!!!!! : " + "${companyList[position].corpNo}")

                val corpNo = "${companyList[position].corpNo}".toLong()

                // 클린한 회사의 corpNo 값을 ProfileActivity로 넘겨줌
                val intent = Intent(activity, ProfileActivity::class.java)
                intent.putExtra("corpNo", corpNo)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        })

    }

}