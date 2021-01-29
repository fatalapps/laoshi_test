package com.laoshi.test.dao

import androidx.room.*
import com.laoshi.test.entities.Entities

@Dao
interface HskDao {
    @Query("SELECT * FROM hsk")
    fun getAll(): List<Entities.Hsk>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    fun insertAll(vararg entities: Entities.Hsk)

    @Delete
    fun delete(entities: Array<out Entities.Hsk>)
}
