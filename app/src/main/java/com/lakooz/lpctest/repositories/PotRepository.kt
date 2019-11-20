package com.lakooz.lpctest.repositories

import com.lakooz.lpctest.MyApplication
import com.lakooz.lpctest.database.AppDatabase
import com.lakooz.lpctest.database.PotDao
import com.lakooz.lpctest.model.Pot
import kotlin.concurrent.thread

class PotRepository(private val potDao: PotDao) {

  
    fun createOrUpdate(pot: Pot) {
        thread {
            potDao.createOrUpdate(pot)
        }
    }

    fun insertAllAndSynchronize(pots: List<Pot>) {
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