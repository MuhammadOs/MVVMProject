package com.example.myproject

import androidx.room.Database
import androidx.room.RoomDatabase

const val version = 1
@Database(entities = [User::class], version = version, exportSchema = true,/*autoMigrations = [AutoMigration(from = version-1, to = version)]*/)
abstract class MyDatabase: RoomDatabase(){
    abstract fun userDao(): User_DAO
    }