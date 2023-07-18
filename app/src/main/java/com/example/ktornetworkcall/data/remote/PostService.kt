package com.example.ktornetworkcall.data.remote

import com.example.ktornetworkcall.data.remote.dto.PostDto
import com.example.ktornetworkcall.data.remote.dto.PostRequest
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

/**
 * Created by Fati Gurqiti on 7/18/2023.
 */
interface PostService {

    suspend fun getPosts(): List<PostDto>

    suspend fun createPost(postRequest: PostRequest): PostDto?

    companion object { // Pretend this is DI
        fun create(): PostService {
            return PostServiceImpl(
                client = HttpClient(Android) // Change for iOS
                {
                    install(Logging) {
                        level = LogLevel.ALL
                    }
                    install(JsonFeature) {
                        serializer = KotlinxSerializer()
                    }
                }
            )
        }
    }
}