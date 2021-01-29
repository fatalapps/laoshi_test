package com.laoshi.test.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.laoshi.test.entities.BookChildren
import com.laoshi.test.entities.Entities
import java.lang.reflect.Type
import java.util.*


class BooksChildrenChildrenConverter {


    private var gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<BookChildren?> {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object : TypeToken<List<BookChildren?>?>() {}.getType()
        return gson.fromJson<List<BookChildren>>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<BookChildren?>?): String {
        return gson.toJson(someObjects)
    }

}