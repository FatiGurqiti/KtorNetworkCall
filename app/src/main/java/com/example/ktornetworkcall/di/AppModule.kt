package com.example.ktornetworkcall.di

import com.example.ktornetworkcall.data.remote.PostServiceImpl
import com.example.ktornetworkcall.presentation.MainViewModel
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Fati Gurqiti on 7/19/2023.
 */

val appModule = module {
    single {
        PostServiceImpl(
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

    viewModel { MainViewModel(get()) }
}