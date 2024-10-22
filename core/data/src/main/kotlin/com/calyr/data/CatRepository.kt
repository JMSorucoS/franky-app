package com.calyr.data

import android.content.Context

class CatRepository( val context: Context) {
    val CatDao = CatAppRoomDatabase.getDatabase(context).catDao()

    suspend fun insert(cat: Cat) {
        CatDao.insert(cat)
    }

    fun getListBooks(): List<Cat> {
        return CatDao.getList()
    }
}