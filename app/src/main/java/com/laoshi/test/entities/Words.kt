package com.laoshi.test.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.laoshi.test.db.ImageObjectConverter
import com.laoshi.test.db.TranslationsObjectConverter

class Words : ArrayList<WordsItem>()

@Entity
data class WordsItem(
    val categories: List<Translations>?,
    @PrimaryKey
    val id: Int?,
    val transcriptions: List<String>?,
    val translations: Translations?,
    val word: String?
)

@TypeConverters(TranslationsObjectConverter::class)
data class Translations(
    val en: String?,
    val ru: String?
)