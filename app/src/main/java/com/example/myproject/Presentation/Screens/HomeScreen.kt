package com.example.myproject.Presentation.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.myproject.Presentation.ViewModels.MainViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: MainViewModel) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Home Screen")
        Button(onClick = {
            viewModel.homeLogoutBtn(navController)
        }) {
            Text(text = "Logout")
        }
        Button(onClick = {
            viewModel.getDummyQuotes()
        }) {
            Text(text = "Call Api")
        }
        Text(text = viewModel.quotesList.value.toString())
    }
}