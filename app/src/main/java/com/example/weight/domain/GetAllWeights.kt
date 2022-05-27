package com.example.weight.domain

import android.content.Context
import com.example.weight.data.entity.Weight
import com.example.weight.data.repository.WeightRepository

class GetAllWeights {

    var repository: WeightRepository

    constructor(context: Context) {
        this.repository = WeightRepository(context)
    }

    suspend operator fun invoke(): MutableList<Weight> {
        return this.repository.getAll()
    }
}