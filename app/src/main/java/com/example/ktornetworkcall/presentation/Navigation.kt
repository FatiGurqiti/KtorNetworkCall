package com.example.ktornetworkcall.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.ktornetworkcall.presentation.ui.CreatePostScreen
import com.example.ktornetworkcall.presentation.ui.HomeScreen
import com.example.ktornetworkcall.presentation.ui.PostDetailsScreen

/**
 * Created by Fati Gurqiti on 7/19/2023.
 */

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.HomeScreen.route) {
        composable(Screens.HomeScreen.route) {
            HomeScreen(navController)
        }

        composable(Screens.CreatePostScreen.route) {
            CreatePostScreen()
        }

        composable(
            route = Screens.PostDetailsScreen.route+"/{post}",
            arguments = listOf(
                navArgument("post") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = false
                }
            )
        ) { entry ->
            PostDetailsScreen(post = entry.arguments?.getString("post") ?: "")
        }
    }
}