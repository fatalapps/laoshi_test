package com.laoshi.test.dao

import androidx.room.*
import com.laoshi.test.entities.Entities

@Dao
interface CollectionDao {
    @Query("SELECT * FROM collection")
    fun getAll(): List<Entities.Collection>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    fun insertAll(vararg entities: Entities.Collection)

    @Delete
    fun delete(entities: Array<out Entities.Collection>)
}
