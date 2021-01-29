package com.laoshi.test.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.laoshi.test.entities.Entities
import com.laoshi.test.entities.Title
import java.lang.reflect.Type
import java.util.*


class TitleConverter {

    private var gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<Title> {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object : TypeToken<List<Title?>?>() {}.getType()
        return gson.fromJson<List<Title>>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<Title?>?): String {
        return gson.toJson(someObjects)
    }

}