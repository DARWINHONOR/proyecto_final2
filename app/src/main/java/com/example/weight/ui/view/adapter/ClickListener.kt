package com.example.weight.ui.view.adapter

import android.view.View
import com.example.weight.data.entity.Weight

interface ClickListener {
    fun onClickEdit(view: View, weight: Weight)
    fun onClickDelete(view: View, weight: Weight)
}