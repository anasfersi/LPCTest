package com.lakooz.lpctest

import android.app.Application
import android.content.Context
import com.lakooz.lpctest.database.AppDatabase


class MyApplication : Application() {

    companion object {
        lateinit var appContext: Context
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        database = AppDatabase.getInstance(appContext)
    }


}