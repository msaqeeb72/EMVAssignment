package com.saqeeb.emvassignment.network.api

import com.saqeeb.emvassignment.models.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UsersAPI {
    @GET("/api/users/{userId}")
    suspend fun portGroupsByCountry(@Path("userId") userId: String): Response<UserResponse>
}