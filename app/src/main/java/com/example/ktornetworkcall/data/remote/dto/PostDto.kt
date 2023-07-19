package com.example.ktornetworkcall.data.remote.dto

@kotlinx.serialization.Serializable
data class PostDto(
    val body: String? = "",
    val id: Int? = 0,
    val title: String? = "",
    val userId: Int? = 0,
    var isSuccessful: Boolean? = null
)