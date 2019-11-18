package com.lakooz.lpctest.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Pot(
    @PrimaryKey(autoGenerate = true)val identifier: String,
    @ColumnInfo(name = "name")val name: String,
    @ColumnInfo(name = "creationDate")val creationDate: Date,
    @ColumnInfo(name = "category")val category: Int,
    @ColumnInfo(name = "contributorsCount")val contributorsCount: Int,
    @ColumnInfo(name = "amount")val amount: Float,
    @ColumnInfo(name = "imageUrl")val imageUrl: String) {


    companion object {
        const val CATEGORY_BIRTHDAY = 0
        const val CATEGORY_FAREWELL = 1
        const val CATEGORY_SOLIDARITY = 2
    }
}