package com.example.myproject.Presentation.ViewModels

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.myproject.Data.Network.NetworkService
import com.example.myproject.Data.PreferencesManager
import com.example.myproject.Data.Network.Quote
import com.example.myproject.Data.appClass
import com.example.myproject.R
import com.example.myproject.User
import com.example.myproject.UserDB
import com.example.myproject.UserRoomDB
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel(private val userDB: UserDB = UserRoomDB()) : ViewModel() {

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/").addConverterFactory(GsonConverterFactory.create())
        .build()


    private val retrofitAPI: NetworkService = retrofit.create(NetworkService::class.java)
    val sharedpref = PreferencesManager(appClass.appContext)

    var quotesList = mutableStateOf<List<Quote>>(emptyList())
    var showPassword = mutableStateOf(false)
    var showPassword2 = mutableStateOf(false)
    var username = mutableStateOf("")
    var passeye = mutableStateOf(R.drawable.baseline_lock_24)
    var passeye2 = mutableStateOf(R.drawable.baseline_lock_24)
    var password = mutableStateOf("")
    var signupUsername = mutableStateOf("")
    var signupEmail = mutableStateOf("")
    var signupAge = mutableStateOf("")
    var signupPassword = mutableStateOf("")
    var signupConfirmPass = mutableStateOf("")
    var clicked = mutableStateOf(false)
    var checked = mutableStateOf(false)
    val isLogged = mutableStateOf(false)

    fun createUser(userName: String, email: String, password: String, age: String): User {
        val user = User(username = userName, gmail = email, password = password, age = age)
        return user
    }

    fun getDummyQuotes() {
        viewModelScope.launch {
            quotesList.value = retrofitAPI.getQuotes().quotes
        }
    }

    fun homeLogoutBtn (navController: NavController) {
        sharedpref.saveData("MyPrefs", false)
        navController.navigate("LoginScreen")
    }

    fun loginBtnClickable(navController: NavController, context: Context) {
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

            (userDB.getUserByUserName(username.value) && userDB.getUserByPassword(password.value)).not() -> {
                Toast.makeText(
                    context,
                    "Username or password could be wrong",
                    Toast.LENGTH_LONG
                ).show()
            }

            else -> {
                Toast.makeText(
                    context,
                    "Logged in Successfully!",
                    Toast.LENGTH_LONG
                ).show()
                isLogged.value = true
                sharedpref.saveData("MyPrefs", true)
                navController.navigate("HomeScreen")
            }
        }
    }

    fun signupBtnClickable(navController: NavController, context: Context, user: User) {
        when {
            signupUsername.value.isEmpty() -> {
                Toast.makeText(
                    context,
                    "Please enter username!",
                    Toast.LENGTH_LONG
                ).show()
            }

            signupEmail.value.isEmpty() -> {
                Toast.makeText(
                    context,
                    "Please enter the Email!",
                    Toast.LENGTH_LONG
                ).show()
            }

            signupPassword.value.isEmpty() -> {
                Toast.makeText(
                    context,
                    "Please enter the password!",
                    Toast.LENGTH_LONG
                ).show()
            }

            signupConfirmPass.value.isEmpty() -> {
                Toast.makeText(
                    context,
                    "Please confirm the password!",
                    Toast.LENGTH_LONG
                ).show()
            }

            signupConfirmPass.value != signupPassword.value -> {
                Toast.makeText(
                    context,
                    "Passwords should be identities",
                    Toast.LENGTH_LONG
                ).show()
            }

            (userDB.getUserByUserName(signupUsername.value)) -> {
                Toast.makeText(
                    context,
                    "Username already exists",
                    Toast.LENGTH_LONG
                ).show()
            }

            else -> {
                Toast.makeText(
                    context,
                    "SignedUp Successfully! Please Login!",
                    Toast.LENGTH_LONG
                ).show()
                userDB.insertUser(user)
                navController.navigate("LoginScreen")
            }
        }
    }
}