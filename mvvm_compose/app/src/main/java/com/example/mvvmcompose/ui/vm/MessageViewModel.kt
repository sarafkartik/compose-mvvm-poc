package com.example.mvvmcompose.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmcompose.data.MessageRepository
import com.example.mvvmcompose.domain.RandomMessageModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MessageViewModel : ViewModel() {
    private val repository: MessageRepository = MessageRepository()
    private val _message = MutableStateFlow(RandomMessageModel.empty())

    fun fetchMessagesPeriodically() {
        viewModelScope.launch {
            while (true) {
                val message = repository.getRandomMessage()
                _message.value = message
                delay(5000) // 5 seconds delay
            }
        }
    }


    fun getMessage(): StateFlow<RandomMessageModel> {
        return _message.asStateFlow()
    }


}