package com.laoshi.test.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.laoshi.test.entities.Description
import com.laoshi.test.entities.Entities
import java.lang.reflect.Type
import java.util.*


class DescriptionObjectConverter {

    private var gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): Description? {
        if (data == null) {
            return Description(null, null)
        }
        val listType: Type = object : TypeToken<Description?>() {}.getType()
        return gson.fromJson<Description>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: Description?): String {
        return gson.toJson(someObjects)
    }

}