package com.example.myproject.Presentation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myproject.Presentation.Screens.LoginScreen
import com.example.myproject.Presentation.Screens.SignupScreen
import com.example.myproject.Presentation.ViewModels.LoginAndSignupViewModel

@Composable
fun NavigationHost(navController: NavHostController) {
    val viewModel = viewModel<LoginAndSignupViewModel>(
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return LoginAndSignupViewModel() as T
            }
        }
    )
    NavHost(navController = navController,
        startDestination = "LoginScreen"
    ) {
        composable("LoginScreen"){ LoginScreen(navController, viewModel) }
        composable("SignupScreen"){ SignupScreen(navController, viewModel) }
    }
}