package com.example.myproject.Data

import android.app.Application
import android.content.Context

class appClass : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }
    companion object {
        lateinit  var appContext: Context
    }
}