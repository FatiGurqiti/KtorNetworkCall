package com.example.ktornetworkcall.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ktornetworkcall.data.remote.PostService
import com.example.ktornetworkcall.data.remote.dto.PostDto
import com.example.ktornetworkcall.presentation.ui.theme.KtorNetworkCallTheme

class MainActivity : ComponentActivity() {

    private val service = PostService.create() // DI this to view model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val posts = produceState(initialValue = emptyList<PostDto>(), producer = {
                value = service.getPosts()
            })
            KtorNetworkCallTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LazyColumn {
                        items(posts.value) {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(15.dp)
                                    .clickable { },
                                elevation = 10.dp,
                                shape = RoundedCornerShape(8.dp),
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                ) {
                                    Text(text = it.title ?: "", fontSize = 22.sp)
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(text = it.body ?: "", fontSize = 14.sp)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}