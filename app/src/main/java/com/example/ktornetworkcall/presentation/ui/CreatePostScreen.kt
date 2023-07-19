package com.example.ktornetworkcall.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ktornetworkcall.data.remote.PostService
import com.example.ktornetworkcall.data.remote.dto.PostRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Fati Gurqiti on 7/19/2023.
 */

private val service = PostService.create()

@Preview
@Composable
fun CreatePostScreen() {
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val coroutineScope = rememberCoroutineScope()
        var userIdText by remember { mutableStateOf("") }
        var postTitleText by remember { mutableStateOf("") }
        var postText by remember { mutableStateOf("") }
        var successStatus by remember { mutableStateOf(false) }


        Text(text = "Hello we create posts in here")

        Spacer(modifier = Modifier.height(18.dp))
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = userIdText,
            onValueChange = {
                userIdText = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = {
                Text("UserId")
            }

        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = postTitleText, onValueChange = {
            postTitleText = it
        }, placeholder = {
            Text("Post Title")
        })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = postText, onValueChange = {
            postText = it
        }, placeholder = {
            Text("Post Body")
        })

        Button(onClick = {
            val postToSend = PostRequest(
                userId = userIdText.toInt(),
                title = postTitleText,
                body = postText
            )

            coroutineScope.launch(Dispatchers.IO) {
                service.createPost(postToSend).also {
                    successStatus = it?.isSuccessful == true
                }
            }
        }) {
            Text(text = "Send")
        }

        Spacer(modifier = Modifier.fillMaxHeight(0.2f))
        Text(
            text = "Result: $successStatus", modifier = Modifier
                .background(
                    color = if (successStatus) Color.Green else Color.Red
                )
                .fillMaxWidth()
                .fillMaxHeight(.1f),
            textAlign = TextAlign.Center,
            fontSize = 22.sp
        )
    }
}