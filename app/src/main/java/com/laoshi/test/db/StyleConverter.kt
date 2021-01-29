package com.laoshi.test.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.laoshi.test.entities.Entities
import java.lang.reflect.Type
import java.util.*


class StyleConverter {

    private var gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<Entities.Collection.Style> {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object : TypeToken<List<Entities.Collection.Style?>?>() {}.getType()
        return gson.fromJson<List<Entities.Collection.Style>>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<Entities.Collection.Style?>?): String {
        return gson.toJson(someObjects)
    }

}