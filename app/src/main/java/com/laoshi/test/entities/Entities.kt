package com.laoshi.test.entities

import org.jetbrains.annotations.Nullable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.laoshi.test.db.*

data class Entities(
    val books: List<Book>,
    val collections: List<Collection>,
    val hsk: List<Hsk>
) {
    @Entity
    data class Book(
        @TypeConverters(BooksChildrenConverter::class)
        @Nullable
        val children: List<Children>?,
        @Nullable
        val description: Description?,
        @PrimaryKey
        val id: Int?,
        val image: Image?,
        val images: List<Any>?,
        val index: Any?,
        val locales: List<Any>?,
        val style: Any?,
        val title: Title?,
        val type: String?,
        val url: Any?,
        val words: List<Any>?,
        val words_count: Int?
    ) {
        @TypeConverters(BooksChObjectConverter::class)
        data class Children(
            val children: List<BookChildren>?,
            val description: Description?,
            val id: Int?,
            val image: Image?,
            val images: List<Any>?,
            val index: Any?,
            val locales: List<Any>?,
            val style: Any?,
            val title: Title?,
            val type: String?,
            val url: Any?,
            val words: List<Any>?,
            val words_count: Int?
        )
    }

    @Entity
    data class Collection(
        @Nullable
        @TypeConverters(CollectionChildrenConvertor::class)
        val children: List<Children>?,
        @Nullable
        val description: Description?,
        @PrimaryKey
        val id: Int?,
        val style: Style?,
        val title: Title?,
        val type: String?,
        val words: List<Any>?
    ) {
        @TypeConverters(AnyObjectConverter::class)
        data class Children(
            @Nullable
            val children: List<Any>?,
            @Nullable
            val description: Description?,
            val id: Int?,
            val style: Any?,
            val title: Title?,
            val type: String?,
            val words: List<Int>?,
            val words_count: Int?
        )

        @TypeConverters(StyleObjectConverter::class)
        data class Style(
            val bottom_color: String?,
            val shape: Int?,
            val top_color: String?
        )
    }

    @Entity
    data class Hsk(
        @Nullable
        @TypeConverters(HskChildrenConverter::class)
        val children: List<Children>?,
        @Nullable
        val description: Description?,
        @PrimaryKey
        val id: Int?,
        val style: Any?,
        val title: Title?,
        val type: String?,
        val words: List<Any>?
    ) {
        @TypeConverters(HskChildrenConverter::class)
        data class Children(
            @Nullable
            val children: List<Any>?,
            @Nullable
            val description: Description?,
            val id: Int?,
            val style: Any?,
            val title: Title?,
            val type: String?,
            val words: List<Int>?,
            val words_count: Int?
        )
    }
}

@TypeConverters(BooksChChObjectConverter::class)
data class BookChildren(
    val children: List<Any>?,
    val description: Description?,
    val id: Int?,
    val image: Any?,
    val images: List<Any>?,
    val index: Int?,
    val locales: List<String>?,
    val style: Any?,
    val title: Title?,
    val type: String?,
    val url: Any?,
    val words: List<Int>?,
    val words_count: Int?
)

@TypeConverters(TitleObjectConverter::class)
data class Title(
    val en: String?,
    val ru: String?
)

@TypeConverters(DescriptionObjectConverter::class)
data class Description(
    val en: String?,
    val ru: String?
)

@TypeConverters(ImageObjectConverter::class)
data class Image(
    val preview: String?,
    val thumbnail: String?
)