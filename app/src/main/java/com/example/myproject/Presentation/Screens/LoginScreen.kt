package com.example.myproject.Presentation.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myproject.Data.appClass
import com.example.myproject.Presentation.CustomComponents.MyLoginTextField
import com.example.myproject.Presentation.ViewModels.LoginAndSignupViewModel
import com.example.myproject.R

@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginAndSignupViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    //val loginViewModel : LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    Box(modifier = Modifier.fillMaxSize()) {
        ClickableText(
            text = AnnotatedString("Sign up here"),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            onClick = {
                navController.navigate("SignupScreen")
            },
            style = TextStyle(
                fontSize = 14.sp,
                textDecoration = TextDecoration.Underline,
                color = Color.DarkGray
            )
        )
    }
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Login",
            Modifier.align(Alignment.Start),
            style = TextStyle(fontSize = 40.sp),
        )
        Text(
            text = "Please sign in to continue",
            Modifier.align(Alignment.Start),
            style = TextStyle(fontSize = 18.sp),
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.height(50.dp))
        MyLoginTextField(
            name = viewModel.username.value,
            onChange = { newValue -> viewModel.username.value = newValue },
            label = "Username",
            visualTransformation = VisualTransformation.None,
            keyboardOption = KeyboardOptions(keyboardType = KeyboardType.Email),
            LeadingIcon = R.drawable.baseline_account_circle_24
        )
        Spacer(modifier = Modifier.height(20.dp))
        MyLoginTextField(
            name = viewModel.password.value,
            onChange = { newValue -> viewModel.password.value = newValue },
            label = "Password",
            keyboardOption = KeyboardOptions(keyboardType = KeyboardType.Password),
            LeadingIcon = R.drawable.baseline_password_24,
            TrailingIcon = viewModel.passeye.value,
            TrailingOnClick = {
                viewModel.passeye.value =
                    if (viewModel.passeye.value == R.drawable.baseline_lock_24) {
                        R.drawable.baseline_lock_open_24
                    } else {
                        R.drawable.baseline_lock_24
                    }
                viewModel.showPassword.value = !viewModel.showPassword.value
            },
            visualTransformation = if (viewModel.showPassword.value) VisualTransformation.None else PasswordVisualTransformation(),
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Checkbox(
                checked = viewModel.checked.value,
                onCheckedChange = { checked_ -> viewModel.checked.value = checked_ },
            )
            Text(text = "Remember me")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)
        ) {
            Button(
                onClick = {
                    viewModel.clicked.value = true
                    viewModel.loginBtnClickable(navController, appClass.appContext)
                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Login")
            }
            Spacer(modifier = Modifier.height(10.dp))
            ClickableText(
                text = AnnotatedString("Forget Password?"),
                onClick = {
                },
                style = TextStyle(
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                ),
            )
        }
    }
}

