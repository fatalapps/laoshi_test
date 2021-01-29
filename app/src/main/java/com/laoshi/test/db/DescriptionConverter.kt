package com.laoshi.test.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.laoshi.test.entities.Description
import com.laoshi.test.entities.Entities
import java.lang.reflect.Type
import java.util.*


class DescriptionConverter {

    private var gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<Description> {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object : TypeToken<List<Description?>?>() {}.getType()
        return gson.fromJson<List<Description>>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<Description?>?): String {
        return gson.toJson(someObjects)
    }

}