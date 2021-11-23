package com.example.chattingapp.ui.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.chattingapp.R
import com.example.chattingapp.data.model.SignUpForm
import com.example.chattingapp.databinding.ActivityLoginBinding
import com.example.chattingapp.ui.MainActivity
import com.example.chattingapp.utils.MyApplication
import com.example.chattingapp.utils.NetworkConnection
import com.example.chattingapp.utils.NetworkStatus
import com.example.chattingapp.utils.toast

class SignInActivity : AppCompatActivity(), AuthListener {

    private lateinit var binding: ActivityLoginBinding
    lateinit var viewModel : AuthViewModel
    lateinit var viewModelFactory: AuthViewModelFactory

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
        viewModelFactory = AuthViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(AuthViewModel::class.java)
        viewModel.authSignInListener = this
        viewModel.isSelected.set(false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        viewModel.signInResponse.observe(this){
            if(it != null){
                MyApplication.prefs.setUserEmail(it.email)
                MyApplication.prefs.setUserName(it.name)

                val intent = Intent(this, MainActivity::class.java)
                val intentData = SignUpForm(binding.loginEmail.text.toString(), binding.loginPassword.text.toString(), it.name, it.gender, it.tel)
                intent.putExtra("user", intentData)
                startActivity(intent)
                finish()
            }
            else{
                toast("error")
                viewModel.removeEditText()
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