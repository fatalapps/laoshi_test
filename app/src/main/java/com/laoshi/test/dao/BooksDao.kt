package com.laoshi.test.dao

import androidx.room.*
import com.laoshi.test.entities.Entities

@Dao
interface BooksDao {
    @Query("SELECT * FROM book")
    fun getAll(): List<Entities.Book>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    fun insertAll(vararg entities: Entities.Book)

    @Delete
    fun delete(entities: Array<out Entities.Book>)
}
