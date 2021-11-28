package com.example.chattingapp.ui.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.chattingapp.R
import com.example.chattingapp.data.service.UserApiService
import com.example.chattingapp.databinding.FragmentChatListBinding
import com.example.chattingapp.databinding.FragmentMyPageBinding

class MypageFragment : Fragment() {

    companion object {
        fun newInstance() : MypageFragment {
            return MypageFragment()
        }
    }

    lateinit var binding: FragmentMyPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_page, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        UserApiService.instance.getMyPage() {
            binding.mypageInputEmail.setText(it.email)
            binding.mypageInputName.setText(it.name)
            binding.mypageInputGender.setText(it.gender)
            binding.mypageInputTel.setText(it.phone)
        }
    }
}