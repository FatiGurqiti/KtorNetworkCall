package com.example.ktornetworkcall.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ktornetworkcall.data.remote.dto.PostDto
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

/**
 * Created by Fati Gurqiti on 7/19/2023.
 */

@Composable
fun PostDetailsScreen(post: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val postDetails = Json.decodeFromString<PostDto>(post)
        Text(text = "${postDetails.title}", fontSize = 22.sp, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "UserId: ${postDetails.userId} ", fontSize = 18.sp)
        Text(text = "Id: ${postDetails.id}", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "${postDetails.body}", fontSize = 18.sp)
    }
}