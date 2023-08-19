package com.example.myproject

import androidx.room.Room
import com.example.myproject.Data.appClass

class UserRoomDB : UserDB{

    val database = Room.databaseBuilder(
        appClass.appContext , MyDatabase::class.java, "Mydatabase"
    ).allowMainThreadQueries().build()
    val dao = database.userDao()

    override fun getAllUsers(): List<User> {
        return dao.getAllUsers()
    }

    override fun insertUser(user: User) {
        dao.addUser(user)
    }

    override fun updateUserByID(id: Int, username: String, age: String?, email: String) {
        dao.updateUserByID(id, username, age, email)
    }

    override fun deleteAll() {
        dao.deleteAll()
    }

    override fun getUserByUserName(username: String): Boolean {
        return dao.getUserByUserName(username)

    }

    override fun getUserByPassword(password: String): Boolean {
        return dao.getUserByPassword(password)
    }
}