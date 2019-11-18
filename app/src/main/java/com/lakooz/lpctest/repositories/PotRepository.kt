package com.lakooz.lpctest.repositories

import android.annotation.SuppressLint
import android.util.Log
import com.lakooz.lpctest.MyApplication
import com.lakooz.lpctest.database.AppDatabase
import com.lakooz.lpctest.database.PotDao
import com.lakooz.lpctest.model.Pot
import kotlin.concurrent.thread

class PotRepository(private val potDao: PotDao) {


    fun createOrUpdate(pot: Pot) {
        potDao.createOrUpdate(pot)
    }

    @SuppressLint("LongLogTag")
    fun insertAllAndSynchronize(pots: List<Pot>) {
        Log.e("insertAllAndSynchronize POT LIST ",pots.toString())
        thread {
            potDao.insertAllAndSynchronize(pots)
        }
    }

    fun getPots(category: Int) = potDao.getPots(category)

    companion object {
        val instance: PotRepository =
            PotRepository(AppDatabase.getInstance(MyApplication.appContext).potDao())
    }


}