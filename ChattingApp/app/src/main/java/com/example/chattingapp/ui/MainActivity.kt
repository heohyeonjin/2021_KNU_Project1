package com.example.chattingapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.chattingapp.R
import com.example.chattingapp.data.model.Corporation
import com.example.chattingapp.databinding.ActivityMainBinding
import com.example.chattingapp.ui.navigation.ChattingListFragment
import com.example.chattingapp.ui.navigation.CompanyListFragment
import com.example.chattingapp.ui.navigation.MypageFragment

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    private lateinit var binding: ActivityMainBinding
    private lateinit var chatListFragment: ChattingListFragment
    private lateinit var companyListFragment: CompanyListFragment
    private lateinit var mypageFragment: MypageFragment
    var companyList: ArrayList<Corporation> = arrayListOf(
        Corporation(1,"samsung","company","company"),
        Corporation(2,"LG","company","company")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.bottomNavigation.apply {
            setOnItemSelectedListener {
                when(it.itemId){
                    R.id.action_company_list -> {
                        companyListFragment = CompanyListFragment.newInstance()
                        supportFragmentManager.beginTransaction().replace(R.id.main_content, companyListFragment).commit()
                        return@setOnItemSelectedListener true
                    }

                    R.id.action_chatting -> {
                        chatListFragment = ChattingListFragment.newInstance()
                        supportFragmentManager.beginTransaction().replace(R.id.main_content, chatListFragment).commit()
                        return@setOnItemSelectedListener true
                    }

                    R.id.action_my_page -> {
                        mypageFragment = MypageFragment.newInstance()
                        supportFragmentManager.beginTransaction().replace(R.id.main_content, mypageFragment).commit()
                        return@setOnItemSelectedListener true
                    }
                }
                false
            }
        }

        binding.bottomNavigation.selectedItemId = R.id.action_company_list
    }

}
