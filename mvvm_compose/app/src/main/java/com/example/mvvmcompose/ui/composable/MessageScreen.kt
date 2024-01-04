package com.example.mvvmcompose.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mvvmcompose.domain.RandomMessageModel
import com.example.mvvmcompose.ui.vm.MessageViewModel

@Composable
fun MessageScreen(viewModel: MessageViewModel) {
    val message by viewModel.getMessage().collectAsState(RandomMessageModel.empty())

    LaunchedEffect(Unit) {
        viewModel.fetchMessagesPeriodically()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (message == RandomMessageModel.empty()) {
            CircularProgressIndicator(color = Color.Black)
        } else {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                Text(
                    text = if (message.content != null) message.content!! else {
                        "Message"
                    }, modifier = Modifier.padding(16.dp)
                )
                Divider()
                Text(
                    text = if (message.authorSlug != null) "by: ${message.authorSlug!!}" else {
                        "Author"
                    }, modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}