package com.example.myproject.Data

import android.app.Application
import android.content.Context

var appContext : Context? = null
class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
}
/*
object AppContext {
    fun context_init (context: Context) : Context
    {
        if (appContext == null)
        val cntxt = context
        return cntxt
    }
}*/