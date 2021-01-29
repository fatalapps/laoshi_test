package com.laoshi.test.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.laoshi.test.entities.Entities
import java.lang.reflect.Type
import java.util.*


class CollectionChildrenConvertor {


    private var gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<Entities.Collection.Children> {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object : TypeToken<List<Entities.Collection.Children?>?>() {}.getType()
        return gson.fromJson<List<Entities.Collection.Children>>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<Entities.Collection.Children?>?): String {
        return gson.toJson(someObjects)
    }

}