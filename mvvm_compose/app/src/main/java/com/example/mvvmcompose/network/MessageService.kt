package com.example.mvvmcompose.network

import com.example.mvvmcompose.domain.RandomMessageModel
import retrofit2.http.GET

interface MessageService {
    @GET("random")
    suspend fun getRandomMessage(): RandomMessageModel
}