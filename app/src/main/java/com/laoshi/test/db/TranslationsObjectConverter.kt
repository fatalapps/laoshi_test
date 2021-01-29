package com.laoshi.test.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.laoshi.test.entities.*
import java.lang.reflect.Type
import java.util.*


class TranslationsObjectConverter {

    private var gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObject(data: String?): Translations? {
        if (data == null) {
            return Translations(null, null)
        }
        val listType: Type = object : TypeToken<Translations?>() {}.getType()
        return gson.fromJson<Translations>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: Translations?): String {
        return gson.toJson(someObjects)
    }

}