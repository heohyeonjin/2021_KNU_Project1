package com.example.chattingapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.widget.TextView
import com.donga.st.app02.common.HttpClass

@SuppressLint("HandlerLeak")
class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    val mHandler = object:Handler(){
        override fun handleMessage(msg: Message) {
            var _sel = msg.what

            when(_sel){
                HttpClass.HTTP_ACTION01 ->{
                    setList_Data (msg.obj.toString())
                }

                HttpClass.HTTP_ACTION02 ->{
                    setList_Data (msg.obj.toString())
                }
            }
        }
    }


    fun setList_Data(_str:String){


    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var _tv = findViewById<TextView>(R.id.main_test_tv)

        _tv.setOnClickListener {
            getData_Test()

        }

    }


    fun getData_Test(){


        var _params = HashMap<String, String>()
        _params.put("url","app_api.php")
        _params.put("action", "getNoti_All_List")
        _params.put("params2", "abc")

        HttpClass( HttpClass.HTTP_ACTION01, mHandler, _params).start()
    }


    fun getData_Test111(){


        var _params = HashMap<String, String>()
        _params.put("url","app_api.php")
        _params.put("action", "getNoti_All_List")
        _params.put("params2", "abc")

        HttpClass( HttpClass.HTTP_ACTION02, mHandler, _params).start()
    }
}