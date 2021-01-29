package com.laoshi.test.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.laoshi.test.entities.Entities
import java.lang.reflect.Type
import java.util.*


class StringConverter {

    private var gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<String> {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object : TypeToken<List<String?>?>() {}.getType()
        return gson.fromJson<List<String>>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<String?>?): String {
        return gson.toJson(someObjects)
    }

}