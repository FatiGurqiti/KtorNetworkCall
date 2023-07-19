package com.example.ktornetworkcall.presentation

/**
 * Created by Fati Gurqiti on 7/19/2023.
 */
sealed class Screens(var route: String) {
    object HomeScreen : Screens("home_screen")
    object CreatePostScreen : Screens("create_post_screen")
    object PostDetailsScreen : Screens("post_details_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}
