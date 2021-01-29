package com.laoshi.test.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.laoshi.test.entities.Entities
import com.laoshi.test.entities.Translations
import java.lang.reflect.Type
import java.util.*


class TranslationsConverter {

    private var gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<Translations> {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object : TypeToken<List<Translations?>?>() {}.getType()
        return gson.fromJson<List<Translations>>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<Translations?>?): String {
        return gson.toJson(someObjects)
    }

}