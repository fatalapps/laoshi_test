package com.laoshi.test.dao

import androidx.room.*
import com.laoshi.test.entities.WordsItem

@Dao
interface WordsDao {
    @Query("SELECT * FROM wordsitem")
    fun getAll(): List<WordsItem>

    @Query("SELECT * FROM wordsitem WHERE id LIKE :first LIMIT 1")
    fun findById(first: String): WordsItem

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    fun insertAll(vararg entities: WordsItem)

    @Delete
    fun delete(entities: Array<out WordsItem>)
}
