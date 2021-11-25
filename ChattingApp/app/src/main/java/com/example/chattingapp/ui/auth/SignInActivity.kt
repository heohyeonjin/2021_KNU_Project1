package com.example.chattingapp.ui.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.chattingapp.R
import com.example.chattingapp.data.model.SignUpForm
import com.example.chattingapp.databinding.ActivityLoginBinding
import com.example.chattingapp.ui.ChatActivity
import com.example.chattingapp.ui.MainActivity
import com.example.chattingapp.utils.MyApplication
import com.example.chattingapp.utils.NetworkConnection
import com.example.chattingapp.utils.NetworkStatus
import com.example.chattingapp.utils.toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class SignInActivity : AppCompatActivity(), AuthListener {
    val TAG = "SignInActivity"

    private lateinit var binding: ActivityLoginBinding
    lateinit var viewModel : AuthViewModel
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        initViewModel()

        val connection = NetworkConnection(applicationContext)
        connection.observe(this){ isConnected ->
            if (isConnected) NetworkStatus.status = true
            else NetworkStatus.status = false
        }

        binding.signUpBtn.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.findPasswordBtn.setOnClickListener {
            val intent = Intent(this, FindPasswordActivity::class.java)
            startActivity(intent)
        }

    }

    private fun initViewModel(){

        var flag = 0 //로그인 성공 시 1, 로그인 실패 시 0
        viewModelFactory = ViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(AuthViewModel::class.java)
        viewModel.authSignInListener = this
        viewModel.isSelected.set(false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this


        viewModel.signInResponse.observe(this){ it ->
            flag = 0
            if(it != null){
                MyApplication.prefs.setUserEmail(it.email)
                MyApplication.prefs.setUserName(it.name)

                Log.d("tag", "로그인!!!!!!!!!!!!!!!!!")

                viewModel.getFcm_Token()
//                viewModel.sendToken()
                
                viewModel.tokenResponse.observe(this) {
                    if (it.equals("true")) {
                        Log.d("tag", "!!!!!!!!!!토큰!!!!!!!!!!11전송")
                    }
                }

                val intent = Intent(this, ChatActivity::class.java)
//                val intentData = SignUpForm(binding.loginEmail.text.toString(), binding.loginPassword.text.toString(), it.name, it.gender, it.tel)
//                intent.putExtra("user", intentData)
                startActivity(intent)
                finish()

            }
            else{
                toast("error")
                viewModel.removeEditText()
            }
        }


        viewModel.tokenResponse.observe(this) {
            if(it.equals("true")) {
                toast("토큰 보냄")
            } else {
                toast("토큰 못보냄")
            }
        }
    }



    override fun onStarted() {}
    override fun onSuccess() {}

    override fun onFailure(message: String, type: Int) {
        when(type){
            0 -> {
                binding.loginEmail.requestFocus()
            }
            1 -> {
                binding.loginPassword.requestFocus()
            }
        }
        toast(message)
    }
}