package com.example.ktornetworkcall.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktornetworkcall.data.remote.PostServiceImpl
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by Fati Gurqiti on 7/19/2023.
 */
class MainViewModel(
    private val service: PostServiceImpl
) : ViewModel() {

    fun call() {
        viewModelScope.launch {
            delay(1000L)
            Log.d("hajde", "${service.getPosts()[0]}")
        }
    }
}