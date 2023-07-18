package com.example.ktornetworkcall.data.remote.dto

/**
 * Created by Fati Gurqiti on 7/18/2023.
 */

@kotlinx.serialization.Serializable
data class PostRequest(
    val body: String,
    val title: String,
    val userId: Int
)
