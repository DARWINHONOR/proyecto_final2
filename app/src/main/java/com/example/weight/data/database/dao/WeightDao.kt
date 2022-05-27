package com.example.weight.data.database.dao

import androidx.room.*
import com.example.weight.data.entity.Weight

@Dao
interface WeightDao {
    @Query("SELECT * FROM weight_table")
    suspend fun getAll(): MutableList<Weight>

    @Query("SELECT * FROM weight_table WHERE id = :id")
    suspend fun getById(id: Int): Weight

    @Update
    suspend fun update(weight: Weight)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weight: MutableList<Weight>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weight: Weight)

    @Delete
    suspend fun delete(weight: Weight)
}