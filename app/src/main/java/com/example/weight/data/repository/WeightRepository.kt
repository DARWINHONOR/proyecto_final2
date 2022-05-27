package com.example.weight.data.repository

import android.content.Context
import com.example.weight.data.database.DataBaseManager
import com.example.weight.data.database.dao.WeightDao
import com.example.weight.data.entity.Weight

class WeightRepository(context: Context) {

    private lateinit var weightDao: WeightDao

    init {
        var db = DataBaseManager.getAppDataBase(context)
        this.weightDao = db!!.weightDao()
    }

    suspend fun getAll(): MutableList<Weight> {
        return weightDao.getAll()
    }

    suspend fun insert(weight: Weight): Boolean {
        weightDao.insert(weight)
        return true
    }

    suspend fun update(weight: Weight): Boolean {
        weightDao.update(weight)
        return true
    }

    suspend fun delete(weight: Weight): Boolean {
        weightDao.delete(weight)
        return true
    }
}