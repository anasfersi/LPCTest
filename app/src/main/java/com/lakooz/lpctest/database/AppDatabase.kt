package com.lakooz.lpctest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lakooz.lpctest.model.Pot

@Database(entities = [Pot::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun potDao(): PotDao

    companion object {

        private const val DATABASE_NAME = "db_lpc_test"
        private var INSTANCE: AppDatabase? = null

        private fun build(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }

         fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE =
                            build(context.applicationContext)
                    }
                }
            }
            return INSTANCE!!
        }
    }
}