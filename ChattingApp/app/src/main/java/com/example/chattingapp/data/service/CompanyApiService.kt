package com.example.chattingapp.data.service

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.chattingapp.data.model.Company
import com.example.chattingapp.data.model.TokenDTO
import com.example.chattingapp.data.service.rest.RestApiService
import com.example.chattingapp.data.service.rest.RestApiServiceCallback
import java.util.function.Consumer

class CompanyApiService(private val restApiService: RestApiService) {

    @RequiresApi(Build.VERSION_CODES.N)
    fun getCompanyList(callback : Consumer<List<Company>>){
        restApiService.getCompanyList().enqueue(RestApiServiceCallback(callback))
    }

    companion object{
        val instance = CompanyApiService(RestApiService.instance)
    }
}