package com.laoshi.test.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.laoshi.test.entities.Entities
import java.lang.reflect.Type
import java.util.*


class AnyObjectConverter {

    private var gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObject(data: String?): Any? {
        if (data == null) {
            return Any()
        }
        val listType: Type = object : TypeToken<Any?>() {}.getType()
        return gson.fromJson<Any>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: Any?): String {
        return gson.toJson(someObjects)
    }

}