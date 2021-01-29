package com.laoshi.test.controllers

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.room.Room
import com.google.gson.Gson
import com.laoshi.test.db.AppDatabase
import com.laoshi.test.entities.Entities
import com.laoshi.test.entities.Words
import com.laoshi.test.entities.WordsItem
import java.io.BufferedReader
import java.lang.Exception
import kotlin.concurrent.thread

class DbController {
    lateinit var db: AppDatabase
    private var AppContext: Context
    private var gson: Gson
    private var allUploaded: MutableLiveData<Boolean>

    constructor(context: Context) {
        AppContext = context
        gson = Gson()
        allUploaded = MutableLiveData()
        allUploaded.postValue(false)
    }

    fun initDb() {
        db = Room.databaseBuilder(
            AppContext,
            AppDatabase::class.java, "laoshi_db"
        ).build()
    }

    fun updateEntities() {
        allUploaded.postValue(false)
        val json_entity = AppContext
            .assets
            .open("entity.json")
            .bufferedReader()
            .use(BufferedReader::readText)
        Log.e("json", json_entity)
        var entityObject = gson.fromJson(json_entity, Entities::class.java)
        Log.e("entities", entityObject.books.size.toString() + " - length")
        var uploadThread = Thread {
            try {
                entityObject.books.forEach {
                    db.booksDao().insertAll(it)
                    Log.e("entities", it.id.toString() + " " + it.title?.ru + "(book) - inserted")
                }
                entityObject.collections.forEach {
                    db.collectionDao().insertAll(it)
                    Log.e(
                        "entities",
                        it.id.toString() + " " + it.title?.ru + "(collection) - inserted"
                    )
                }
                entityObject.hsk.forEach {
                    db.hskDao().insertAll(it)
                    Log.e("entities", it.id.toString() + " " + it.title?.ru + "(hsk) - inserted")
                }
                allUploaded.postValue(true)
            } catch (e: Exception) {
                allUploaded.postValue(true)
            }
        }
        uploadThread.start()
        Log.e("entities", entityObject.toString())
    }

    fun updateWords() {
        allUploaded.postValue(false)
        val json_entity = AppContext
            .assets
            .open("words.json")
            .bufferedReader()
            .use(BufferedReader::readText)
        Log.e("json", json_entity)
        var entityObject = gson.fromJson(json_entity, Words::class.java)
        Log.e(
            "words",
            (entityObject as ArrayList<WordsItem>).size.toString() + " - length of words"
        )
        var uploadThread = Thread {
            try {
                (entityObject as ArrayList<WordsItem>).forEach {
                    db.wordsDao().insertAll(it)
                    //Log.e("words", it.id.toString() + " " + it.word+ "(word) - inserted")
                }
                allUploaded.postValue(true)
            } catch (e: Exception) {
                allUploaded.postValue(true)
            }
        }
        uploadThread.start()
        Log.e("words", entityObject.toString())
    }

    fun getBooks(): LiveData<List<Entities.Book>> {
        var liveBooks = MutableLiveData<List<Entities.Book>>()
        var selectThread = Thread {
            val bookList: List<Entities.Book> = db.booksDao().getAll()
            Log.e("entities", bookList.size.toString() + "(books) selected and passed")
            liveBooks.postValue(bookList)
        }
        if (allUploaded.value == true) {
            Log.e("entities", "allUploaded is true")
            selectThread.start()
        } else {
            Log.e("entities", "waiting till allUploaded is true...")
            allUploaded.observe(AppContext as AppCompatActivity, Observer {
                Log.e("entities", "allUploaded state changed to " + it.toString())
                if (it) {
                    selectThread.start()
                }
            })
        }
        return liveBooks
    }

    fun getWord(id: String): LiveData<WordsItem> {
        var liveWord = MutableLiveData<WordsItem>()
        var selectThread = Thread {
            val wordItem: WordsItem = db.wordsDao().findById(id)
            Log.e("word", wordItem.word + "(word) selected and passed")
            liveWord.postValue(wordItem)
        }
        if (allUploaded.value == true) {
            Log.e("entities", "allUploaded is true")
            selectThread.start()
        } else {
            Log.e("entities", "waiting till allUploaded is true...")
            allUploaded.observe(AppContext as AppCompatActivity, Observer {
                Log.e("entities", "allUploaded state changed to " + it.toString())
                if (it) {
                    selectThread.start()
                }
            })
        }
        return liveWord
    }

    fun getCollection(): LiveData<List<Entities.Collection>> {
        var liveCollection = MutableLiveData<List<Entities.Collection>>()
        var selectThread = Thread {
            val collectionList: List<Entities.Collection> = db.collectionDao().getAll()
            Log.e("entities", collectionList.size.toString() + "(collection) selected and passed")
            liveCollection.postValue(collectionList)
        }
        if (allUploaded.value == true) {
            Log.e("entities", "allUploaded is true")
            selectThread.start()
        } else {
            Log.e("entities", "waiting till allUploaded is true...")
            allUploaded.observe(AppContext as AppCompatActivity, Observer {
                Log.e("entities", "allUploaded state changed to " + it.toString())
                if (it) {
                    selectThread.start()
                }
            })
        }
        return liveCollection
    }

    fun getHsk(): LiveData<List<Entities.Hsk>> {
        var liveHsk = MutableLiveData<List<Entities.Hsk>>()
        var selectThread = Thread {
            val hskList: List<Entities.Hsk> = db.hskDao().getAll()
            Log.e("entities", hskList.size.toString() + "(hsk) selected and passed")
            liveHsk.postValue(hskList)
        }
        if (allUploaded.value == true) {
            Log.e("entities", "allUploaded is true")
            selectThread.start()
        } else {
            Log.e("entities", "waiting till allUploaded is true...")
            allUploaded.observe(AppContext as AppCompatActivity, Observer {
                Log.e("entities", "allUploaded state changed to " + it.toString())
                if (it) {
                    selectThread.start()
                }
            })
        }
        return liveHsk
    }
}