package com.example.chattingapp.ui.navigation

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

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       
        companyAdapter = CompanyAdapter(companyList)
        companyRecyclerView = view.findViewById(R.id.fragment_company_list_recyclerview)
        companyRecyclerView.adapter = companyAdapter
        companyRecyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        companyRecyclerView.setHasFixedSize(true)

//        val connection = NetworkConnection(applicationContext)
//        connection.observe(this){ isConnected ->
//            if (isConnected) NetworkStatus.status = true
//            else NetworkStatus.status = false
//        }

        CompanyApiService.instance.getCompanyList(){
            Log.d("tag", "!!!!!!!!!1컴퍼니 리스트 응답!!!!!")
            for(company in it) {
                companyAdapter.setCompany(company)
            }
        }


    }

}