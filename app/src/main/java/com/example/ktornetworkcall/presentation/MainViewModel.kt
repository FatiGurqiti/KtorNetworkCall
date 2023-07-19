package com.example.ktornetworkcall.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktornetworkcall.data.remote.PostService
import kotlinx.coroutines.launch

/**
 * Created by Fati Gurqiti on 7/19/2023.
 */
class MainViewModel : ViewModel() {

    fun call() {
        println("hajde test")
//        viewModelScope.launch {
//            println("Hajde vm: ${service.getPosts().get(0)}")
//        }
    }
}