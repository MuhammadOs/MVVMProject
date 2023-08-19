package com.example.myproject

interface UserDB {
    fun getAllUsers() : List<User>
    fun insertUser(user: User)
    fun updateUserByID(id: Int, username: String, age: String?, email: String)
    fun deleteAll()
    fun getUserByUserName(username: String) :Boolean
    fun getUserByPassword(password: String) :Boolean
}