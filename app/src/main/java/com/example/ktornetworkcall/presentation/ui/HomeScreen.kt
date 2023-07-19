package com.example.ktornetworkcall.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ktornetworkcall.data.remote.PostService
import com.example.ktornetworkcall.data.remote.dto.PostDto
import com.example.ktornetworkcall.presentation.Screens

/**
 * Created by Fati Gurqiti on 7/19/2023.
 */

private val service = PostService.create() // DI this to view model

@Composable
fun HomeScreen() {
    val posts = produceState(initialValue = emptyList<PostDto>(), producer = {
        value = service.getPosts()
    })
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colors.background,
    ) {

        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    /*TODO*/
                }) {
                    Text(text = "Create a post", fontSize = 18.sp)
                }
            }

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