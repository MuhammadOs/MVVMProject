package com.example.myproject.Presentation.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.myproject.Data.PreferencesManager
import com.example.myproject.Data.appClass
import com.example.myproject.Presentation.ViewModels.LoginAndSignupViewModel
import com.example.myproject.Presentation.ViewModels.MainViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: LoginAndSignupViewModel) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Home Screen")
        Button(onClick = {
            viewModel.sharedpref.saveData("MyPrefs", false)
            navController.navigate("LoginScreen")
        }) {
            Text(text = "Logout")
        }
    }
}