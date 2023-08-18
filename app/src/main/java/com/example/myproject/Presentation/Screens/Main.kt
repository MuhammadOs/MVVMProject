package com.example.myproject.Presentation.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.myproject.Presentation.NavigationHost
import com.example.myproject.Presentation.ViewModels.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(viewModel: LoginViewModel) {
    val navController = rememberNavController()
    Scaffold {paddingValues ->
        Column (
            modifier = Modifier.padding(paddingValues)
        ){
            NavigationHost(navController = navController, viewModel)
        }
    }
}