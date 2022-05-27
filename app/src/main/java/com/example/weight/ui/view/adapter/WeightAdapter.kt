package com.example.weight.ui.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weight.R
import com.example.weight.data.entity.Weight
import com.google.android.material.card.MaterialCardView
import java.text.SimpleDateFormat

class WeightAdapter(): RecyclerView.Adapter<WeightAdapter.ViewHolder>() {

    private var weights: MutableList<Weight> = mutableListOf()
    private lateinit var clickListener: ClickListener

    constructor(weights: MutableList<Weight>): this() {
        this.weights = weights
    }

    fun setClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weight, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = weights[position]
        holder.weight.text = item.weight.toString()
        holder.title.text = SimpleDateFormat("yyyy-MM-hh").format(item.date)
        holder.detail.text = item.detail

//        holder.edit .setOnClickListener {
//            clickListener.onClickEditNote(holder.itemView, item)
//        }
//
//        holder.delete .setOnClickListener {
//            clickListener.onClickDeleteNote(holder.itemView, item)
//        }
    }

    override fun getItemCount(): Int {
        return weights.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var weight = itemView.findViewById<TextView>(R.id.weight)
        var title = itemView.findViewById<TextView>(R.id.title)
        var detail = itemView.findViewById<TextView>(R.id.detail)
        var container = itemView.findViewById<MaterialCardView>(R.id.container)
        var edit = itemView.findViewById<ImageView>(R.id.edit)
        var delete = itemView.findViewById<ImageView>(R.id.delete)
        var favority = itemView.findViewById<ImageView>(R.id.favorite)
    }
}