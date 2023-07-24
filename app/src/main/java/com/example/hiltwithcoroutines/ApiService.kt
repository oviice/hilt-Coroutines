package com.example.hiltwithcoroutines

import com.example.hiltwithcoroutines.model.Response
import com.example.hiltwithcoroutines.model.ResponseItem
import com.example.hiltwithcoroutines.model.UserResponseItem
import okhttp3.ResponseBody
import retrofit2.http.GET

interface ApiService {
    @GET("users") // Replace "endpoint" with your API endpoint
    suspend fun fetchData(): List<UserResponseItem>
}