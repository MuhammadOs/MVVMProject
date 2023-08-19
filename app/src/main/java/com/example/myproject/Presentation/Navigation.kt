package com.example.myproject.Presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myproject.Data.PreferencesManager
import com.example.myproject.Data.appClass
import com.example.myproject.Presentation.Screens.HomeScreen
import com.example.myproject.Presentation.Screens.LoginScreen
import com.example.myproject.Presentation.Screens.SignupScreen
import com.example.myproject.Presentation.ViewModels.LoginAndSignupViewModel
import com.example.myproject.Presentation.ViewModels.MainViewModel
import kotlin.properties.Delegates

@Composable
fun NavigationHost(navController: NavHostController) {
    val loginAndSignupViewModel = viewModel<LoginAndSignupViewModel>()
    val homeViewModel = viewModel<MainViewModel>()
    NavHost(navController = navController,
        startDestination = if (loginAndSignupViewModel.sharedpref.getData("MyPrefs", false)) {"HomeScreen"} else "LoginScreen"
    ) {
        composable("LoginScreen"){ LoginScreen(navController, loginAndSignupViewModel) }
        composable("SignupScreen"){ SignupScreen(navController, loginAndSignupViewModel) }
        composable("HomeScreen"){HomeScreen(navController, loginAndSignupViewModel)}
    }
}