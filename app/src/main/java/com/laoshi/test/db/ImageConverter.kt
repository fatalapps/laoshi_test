package com.laoshi.test.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.laoshi.test.entities.Entities
import com.laoshi.test.entities.Image
import java.lang.reflect.Type
import java.util.*


class ImageConverter {

    private var gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<Image> {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object : TypeToken<List<Image?>?>() {}.getType()
        return gson.fromJson<List<Image>>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<Image?>?): String {
        return gson.toJson(someObjects)
    }

}