package com.lakooz.lpctest.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lakooz.lpctest.model.Pot


@Dao
abstract class PotDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun createOrUpdate(pot: Pot)

    @Query("SELECT * FROM Pot WHERE category == :value")
    abstract fun getPots(value: Int): List<Pot>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAllAndSynchronize(Pots : List<Pot>)

}