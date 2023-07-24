package com.example.hiltwithcoroutines

import com.example.hiltwithcoroutines.model.Response
import com.example.hiltwithcoroutines.model.ResponseItem
import okhttp3.ResponseBody
import retrofit2.http.GET

interface ApiService {
    @GET("users/1/repos") // Replace "endpoint" with your API endpoint
    suspend fun fetchData(): List<ResponseItem>
}