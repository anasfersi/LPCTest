package com.lakooz.lpctest.database

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun fromTimestamp(value: Long): Date = Date(value)

    @TypeConverter
    fun fromDate(date: Date): Long = date.time
}