package com.example.chattingapp.ui.auth

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chattingapp.R
import com.example.chattingapp.data.model.ApiResult
import com.example.chattingapp.utils.MyApplication
import com.example.chattingapp.utils.NetworkStatus
import androidx.lifecycle.viewModelScope
import com.example.chattingapp.data.model.SignInForm
import com.example.chattingapp.data.model.SignUpForm
import com.example.chattingapp.data.service.TokenApiService
import com.example.chattingapp.data.service.UserApiService
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.launch

class AuthViewModel() : ViewModel() {

    //sign up field
    var signupName = ObservableField<String>()
    var signupPassword = ObservableField<String>()
    var signupEmail = ObservableField<String>()
    var signupPhone = ObservableField<String>()
    var signupGender = ObservableField<Int>()
    var signUpResponseCode = ""
    var TAG = ""

    // signIn field
    var signInEmail = ObservableField<String>()
    var signInPassword = ObservableField<String>()
    var isSelected = ObservableField<Boolean>()

    // token
    var sendToken = ""

    //auth listener
    var authSignUpListener: AuthListener? = null
    var authSignInListener: AuthListener? = null
    var networkErrorString = "네트워크 연결을 확인해 주세요."


    // 회원가입
    private val _signUpResponse : MutableLiveData<String> = MutableLiveData()
    val signUpResponse : LiveData<String> get() = _signUpResponse

    private val _signUpLoading = MutableLiveData<Boolean>()
    val signUpLoading: LiveData<Boolean> get() = _signUpLoading //회원가입, 회원 가입 인증번호 요청, 회원 가입 인증번호 확인 시 사용

    fun postSignUP() = viewModelScope.launch {
        if(NetworkStatus.status){
            _signUpLoading.postValue(true)

            _signUpResponse.value = UserApiService.instance.signUp(
                SignUpForm(signupEmail.get()!!, signupPassword.get()!!, signupName.get()!!, signupGender.get()!!, signupPhone.get()!!)
            )

        }
        else{
            authSignUpListener?.onFailure(networkErrorString,99)
        }
    }

    // 로그인
    private val _signInResponse : MutableLiveData<SignUpForm> = MutableLiveData()
    private val _tokenResponse : MutableLiveData<String> = MutableLiveData()
    val signInResponse : LiveData<SignUpForm> = _signInResponse
    val tokenResponse : LiveData<String> = _tokenResponse

    private val _signInLoading = MutableLiveData<Boolean>()
    val signInLoading: LiveData<Boolean> get() = _signInLoading

    fun postSignIn() = viewModelScope.launch {
        if(NetworkStatus.status){
//            Log.d("tag", "aaaaaaaaa")
            _signInLoading.postValue(true)
            if(isSelected.get()!!){
                MyApplication.prefs.setUserEmail(signInEmail.get()!!)
                MyApplication.prefs.setUserPass(signInPassword.get()!!)
            }
            _signInResponse.value = UserApiService.instance.login(
                SignInForm(signInEmail.get()!!, signInPassword.get()!!)
            )

            _signInLoading.postValue(false)
        }
        else{
            Log.d("networkStatus","in viewmodel " + NetworkStatus.status.toString())
            authSignInListener?.onFailure("네트워크 연결을 확인해 주세요.",99)
        }

    }

    fun sendToken() = viewModelScope.launch {
        if(NetworkStatus.status){
//            Log.d("tag", "aaaaaaaaa")
            _signInLoading.postValue(true)

            getFcm_Token()
            _tokenResponse.value = TokenApiService.instance.getToken(sendToken)

            _signInLoading.postValue(false)
        }
        else{
            Log.d("networkStatus","in viewmodel " + NetworkStatus.status.toString())
            authSignInListener?.onFailure("네트워크 연결을 확인해 주세요.",99)
        }
    }

    fun getFcm_Token() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result

            //val msg = getString(R.string.msg_token_fmt, token)

            /** 실행시마다 서버에 토큰값 저장. */

            /** 실행시마다 서버에 토큰값 저장. */
            Log.d(TAG, token!! )

            sendToken = token

            Log.d(TAG, "토큰 받아옴 : " + sendToken)

        })
    }

    // 로그인 필드 확인
    fun checkSignInField(){
        Log.d("networkStatus","in checkSignInFeild")
        if(signInEmail.get().isNullOrEmpty()){
            authSignInListener?.onFailure("이메일을 입력해주세요",0)
            return
        }
        if(signInPassword.get().isNullOrEmpty()){
            authSignInListener?.onFailure("비밀번호를 입력해주세요",1)
            return
        }

        postSignIn()
    }

    // 회원가입 필드 확인
    fun checkSignUpFeild(){
        if(signupName.get().isNullOrEmpty()){
            authSignUpListener?.onFailure("이름을 입력해주세요", 1)
            return
        }
        if(signupPassword.get().isNullOrEmpty()){
            authSignUpListener?.onFailure("비밀번호를 입력해주세요", 2)
            return
        }
        if(signupEmail.get().isNullOrEmpty()){
            authSignUpListener?.onFailure("이메일을 입력해주세요", 3)
            return
        }
        if(signupPhone.get().isNullOrEmpty()){
            authSignUpListener?.onFailure("전화번호를 입력해주세요", 4)
            return
        }

        postSignUP()
    }

    fun removeEditText(){
        signInEmail.set("")
        signInPassword.set("")
    }

    fun getSharedPreference(){
        if(!MyApplication.prefs.getUserEmail()!!.equals("") && !MyApplication.prefs.getUserPass()!!.equals("")) {
            signInEmail.set(MyApplication.prefs.getUserEmail()!!)
            signInPassword.set(MyApplication.prefs.getUserPass()!!)
            Log.d("networkStatus","in getSharedPreference")
            checkSignInField()
        }
        else
            return
    }

    fun setSignInLoadingFalse(){
        _signUpLoading.postValue(false)
    }

}