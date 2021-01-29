package com.laoshi.test.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.laoshi.test.entities.BookChildren
import com.laoshi.test.entities.Entities
import java.lang.reflect.Type
import java.util.*


class BooksChChObjectConverter {

    private var gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObject(data: String?): BookChildren? {
        if (data == null) {
            return BookChildren(
                null, null, null, null, null, null, null, null,
                null, null, null, null, null
            )
        }
        val listType: Type = object : TypeToken<BookChildren?>() {}.getType()
        return gson.fromJson<BookChildren>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: BookChildren?): String {
        return gson.toJson(someObjects)
    }

}