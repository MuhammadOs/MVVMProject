package com.example.myproject

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface User_DAO {
    @Query("SELECT * FROM User_table")
    fun getAllUsers() : List<User>

    @Query("SELECT * FROM User_table")
    fun getAllUserslive(): LiveData<List<User>>

    @Query("SELECT * FROM User_table WHERE id = :id")
    fun getUserByID(id: Int): User

    @Query("SELECT * FROM User_table WHERE age < :minAge")
    fun getUserByMinAge(minAge: Int): User

    @Insert
    fun addUser(user: User)

    @Update
    fun updateUser(user: User)

    @Query("DELETE FROM User_table")
    fun deleteAll()

    @Query("DELETE FROM User_table where id = :id")
    fun DeleteUserById(id: Int)

    @Query("UPDATE User_table SET age = :age, username = :username, gmail = :email WHERE id = :id")
    fun updateUserByID(id: Int, username: String, age: String?, email: String)

    @Query("UPDATE User_table SET age = :age , username = :username WHERE id = :id")
    fun updateUserManually(id : Int,username: String, age: Int)
}