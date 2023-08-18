package com.example.myproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "User_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val username: String,
    val age: String,
    val gmail: String,
    @ColumnInfo("password", defaultValue = "Pass") val password: String
)