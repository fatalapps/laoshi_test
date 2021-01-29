package com.laoshi.test.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.laoshi.test.entities.Entities
import java.lang.reflect.Type
import java.util.*


class BooksChObjectConverter {

    private var gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObject(data: String?): Entities.Book.Children? {
        if (data == null) {
            return Entities.Book.Children(
                null, null, null, null, null, null, null, null,
                null, null, null, null, null
            )
        }
        val listType: Type = object : TypeToken<Entities.Book.Children?>() {}.getType()
        return gson.fromJson<Entities.Book.Children>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: Entities.Book.Children?): String {
        return gson.toJson(someObjects)
    }

}