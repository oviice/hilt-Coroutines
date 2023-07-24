package com.example.hiltwithcoroutines

import com.example.hiltwithcoroutines.model.UserResponseItem
import retrofit2.http.GET

interface ApiService {
    @GET("users") // Replace "endpoint" with your API endpoint
    suspend fun fetchData(): List<UserResponseItem>
}