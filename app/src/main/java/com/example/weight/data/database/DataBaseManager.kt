package com.example.weight.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weight.data.database.dao.WeightDao
import com.example.weight.data.entity.Weight

@Database(
    entities = [Weight::class],
    version = 1
)
abstract class DataBaseManager : RoomDatabase() {

    abstract fun weightDao(): WeightDao

    companion object {

        var INSTANCE: DataBaseManager? = null

        fun getAppDataBase(context: Context): DataBaseManager? {
            if (INSTANCE == null) {
                synchronized(DataBaseManager::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, DataBaseManager::class.java, "database1").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase() {
            INSTANCE = null
        }
    }
}