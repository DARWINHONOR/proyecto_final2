package com.example.weight.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "weight_table")
data class Weight (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "weight") val weight: Int,
    @ColumnInfo(name = "detail") val detail: String,
    @ColumnInfo(name = "status") val status: Int
): Serializable