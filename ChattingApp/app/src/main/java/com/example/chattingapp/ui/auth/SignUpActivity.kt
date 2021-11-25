package com.example.chattingapp.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.chattingapp.R
import com.example.chattingapp.databinding.ActivitySignUpBinding
import com.example.chattingapp.utils.NetworkConnection
import com.example.chattingapp.utils.NetworkStatus
import com.example.chattingapp.utils.toast

class SignUpActivity : AppCompatActivity() , AuthListener{

    private lateinit var binding: ActivitySignUpBinding
    lateinit var viewModel : AuthViewModel
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        val connection = NetworkConnection(applicationContext)
        connection.observe(this){ isConnected ->
            if (isConnected) NetworkStatus.status = true
            else NetworkStatus.status = false
        }

        initViewModel()
    }

    private fun initViewModel(){
        var emailCheckFlag : Int = 0
        viewModelFactory = ViewModelFactory()
        viewModel = ViewModelProvider(this,viewModelFactory).get(AuthViewModel::class.java)
        viewModel.authSignUpListener = this
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        viewModel.getResponse.observe(this) {
            viewModel.setSignInLoadingFalse()
            if (it.equals("true")) { //이메일 중복 아님
                toast("사용가능한 이메일입니다.")
                emailCheckFlag = 1
            } else {
                toast("이미 가입된 이메일입니다.")
                emailCheckFlag = 0
            }

        }
        
        viewModel.signUpResponse.observe(this) {
            viewModel.setSignInLoadingFalse()

            if (emailCheckFlag == 0) {
                toast("이메일 중복 체크를 해주세요.")
            } else {
                if (it.equals("true")) {
                    toast("회원 가입 완료")

                    val intent = Intent(this, SignInActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    toast("회원 가입 실패")
                }
            }

        }

    }


    override fun onStarted() {}

    override fun onSuccess() {}

    override fun onFailure(message: String, type: Int) {
        when(type) {
            1 -> binding.signUpName.requestFocus()
            2 -> binding.signUpPassword.requestFocus()
            3 -> binding.signUpEmailText.requestFocus()
            4 -> binding.signUpPhoneNumber.requestFocus()
            5 -> binding.radioGroup.requestFocus()
        }
        toast(message)
    }
}