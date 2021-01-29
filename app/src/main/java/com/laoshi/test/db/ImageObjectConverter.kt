package com.laoshi.test.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.laoshi.test.entities.Description
import com.laoshi.test.entities.Entities
import com.laoshi.test.entities.Image
import java.lang.reflect.Type
import java.util.*


class ImageObjectConverter {

    private var gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): Image? {
        if (data == null) {
            return Image(null, null)
        }
        val listType: Type = object : TypeToken<Image?>() {}.getType()
        return gson.fromJson<Image>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: Image?): String {
        return gson.toJson(someObjects)
    }

}