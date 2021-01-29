package com.laoshi.test.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.laoshi.test.entities.Description
import com.laoshi.test.entities.Entities
import com.laoshi.test.entities.Title
import java.lang.reflect.Type
import java.util.*


class TitleObjectConverter {

    private var gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): Title? {
        if (data == null) {
            return Title(null, null)
        }
        val listType: Type = object : TypeToken<Title?>() {}.getType()
        return gson.fromJson<Title>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: Title?): String {
        return gson.toJson(someObjects)
    }

}