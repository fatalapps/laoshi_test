package com.laoshi.test.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.laoshi.test.entities.Description
import com.laoshi.test.entities.Entities
import java.lang.reflect.Type
import java.util.*


class StyleObjectConverter {

    private var gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): Entities.Collection.Style? {
        if (data == null) {
            return Entities.Collection.Style(null, null, null)
        }
        val listType: Type = object : TypeToken<Entities.Collection.Style?>() {}.getType()
        return gson.fromJson<Entities.Collection.Style>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: Entities.Collection.Style?): String {
        return gson.toJson(someObjects)
    }

}