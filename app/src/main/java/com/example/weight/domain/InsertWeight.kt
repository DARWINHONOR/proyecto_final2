package com.example.weight.domain

import android.content.Context
import com.example.weight.data.entity.Weight
import com.example.weight.data.repository.WeightRepository

class InsertWeight {
    var repository: WeightRepository

    constructor(context: Context) {
        this.repository = WeightRepository(context)
    }

    suspend operator fun invoke(weight: Weight): Boolean {
        return this.repository.insert(weight)
    }
}