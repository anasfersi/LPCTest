package com.lakooz.lpctest

import android.app.Application
import android.content.Context
import com.lakooz.lpctest.database.AppDatabase


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MyApplication.appContext = applicationContext
        database = AppDatabase.getInstance(MyApplication.appContext)
    }

    companion object {
        lateinit var appContext: Context
        lateinit var database: AppDatabase
            private set

    }
}