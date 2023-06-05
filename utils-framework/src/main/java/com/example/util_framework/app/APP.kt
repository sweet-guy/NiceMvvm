package com.example.util_framework.app

import android.app.Application
import android.content.Context

open class APP : Application() {
    override fun onCreate() {
        super.onCreate()
    }
    companion object
    {
        private lateinit var baseApplication: APP
        fun getContext():Context{
            return baseApplication
        }
    }
}