package com.example.ktornetworkcall.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.ktornetworkcall.presentation.Screens

/**
 * Created by Fati Gurqiti on 7/19/2023.
 */

@Composable
fun CreatePostScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hello we create posts in here")
    }
}