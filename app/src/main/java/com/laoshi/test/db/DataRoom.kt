package com.laoshi.test.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.laoshi.test.dao.BooksDao
import com.laoshi.test.dao.CollectionDao
import com.laoshi.test.dao.HskDao
import com.laoshi.test.dao.WordsDao
import com.laoshi.test.entities.Entities
import com.laoshi.test.entities.Translations
import com.laoshi.test.entities.WordsItem

@Database(
    entities = [Entities.Book::class, Entities.Hsk::class, Entities.Collection::class, WordsItem::class],
    version = 1
)
@TypeConverters(
    HskChildrenConverter::class,
    CollectionChildrenConvertor::class,
    BooksChildrenConverter::class,
    BooksChildrenChildrenConverter::class,
    DescriptionObjectConverter::class,
    TitleObjectConverter::class,
    ImageObjectConverter::class,
    StyleObjectConverter::class,
    BooksChObjectConverter::class,
    BooksChChObjectConverter::class,
    TitleConverter::class,
    DescriptionConverter::class,
    StyleConverter::class,
    ImageConverter::class,
    AnyConverter::class,
    AnyObjectConverter::class,
    TranslationsObjectConverter::class,
    StringConverter::class,
    TranslationsConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun booksDao(): BooksDao
    abstract fun hskDao(): HskDao
    abstract fun collectionDao(): CollectionDao
    abstract fun wordsDao(): WordsDao

}
