package com.example.myproject.Presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myproject.Presentation.Screens.LoginScreen
import com.example.myproject.Presentation.Screens.SignupScreen
import com.example.myproject.Presentation.ViewModels.LoginViewModel

@Composable
fun NavigationHost(navController: NavHostController, viewModel: LoginViewModel) {

    NavHost(navController = navController,
        startDestination = "LoginScreen"
    ) {
        composable("LoginScreen"){ LoginScreen(navController, viewModel) }
        composable("SignupScreen"){ SignupScreen(navController, viewModel) }
    }
}