package com.calyr.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Cat::class], version = 1)
abstract class CatAppRoomDatabase : RoomDatabase() {
    abstract fun catDao(): ICatDao

    companion object {
        @Volatile
        private var Instance: CatAppRoomDatabase? = null

        fun getDatabase(context: Context): CatAppRoomDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, CatAppRoomDatabase::class.java, "item_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}