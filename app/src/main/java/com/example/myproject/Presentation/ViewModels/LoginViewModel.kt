package com.example.myproject.Presentation.ViewModels

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.myproject.Data.ApplicationClass
import com.example.myproject.Data.appContext
import com.example.myproject.R

class LoginViewModel : ViewModel() {
    val context = appContext
    var showPassword = mutableStateOf(false)
    var showPassword2 = mutableStateOf(false)
    var username = mutableStateOf("")
    var passeye = mutableStateOf(R.drawable.baseline_lock_24)
    var passeye2 = mutableStateOf(R.drawable.baseline_lock_24)
    var password = mutableStateOf("")
    var signupUsername = mutableStateOf("")
    var signupEmail = mutableStateOf("")
    var signupPassword = mutableStateOf("")
    var signupConfirmpass = mutableStateOf("")
    var clicked = mutableStateOf(false)
    var checked = mutableStateOf(false)


    fun loginBtnClickable (navController: NavController, context: Context) {
        when {
            username.value.isEmpty() -> {
                Toast.makeText(
                    context,
                    "Please enter username!",
                    Toast.LENGTH_LONG
                ).show()
            }
            password.value.isEmpty() -> {
                Toast.makeText(
                    context,
                    "Please enter the password!",
                    Toast.LENGTH_LONG
                ).show()
            }
            else -> {
                Toast.makeText(
                    context,
                    "Logged in Successfully!",
                    Toast.LENGTH_LONG
                ).show()
                navController.navigate("SignupScreen")
            }
        }
    }
    fun signupBtnClickable () {

    }
}