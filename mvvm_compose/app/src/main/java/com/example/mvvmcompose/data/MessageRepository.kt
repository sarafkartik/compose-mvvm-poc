package com.example.mvvmcompose.data

import com.example.mvvmcompose.domain.RandomMessageModel
import com.example.mvvmcompose.network.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MessageRepository {
    private val messageService = ApiClient.messageService

    suspend fun getRandomMessage(): RandomMessageModel {
        return messageService.getRandomMessage()
    }

    //For emitting directly
    fun getRandomMessageFlow(): Flow<RandomMessageModel> {
        return flow {
            val message = messageService.getRandomMessage()

            emit(message)
        }.flowOn(Dispatchers.IO)
    }
}