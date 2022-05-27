package com.example.weight.ui.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.weight.R
import com.example.weight.data.entity.Weight
import com.example.weight.databinding.ActivityMainBinding
import com.example.weight.ui.view.adapter.ClickListener
import com.example.weight.ui.view.adapter.WeightAdapter
import com.example.weight.ui.viewmodel.WeightViewModel
import java.util.*

class MainActivity : AppCompatActivity() {

    private val weightViewModel: WeightViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        weightViewModel.init(this)

        weightViewModel.loading.observe(this) { show ->
            if (show) {
                binding.progress.visibility = View.VISIBLE
            } else {
                binding.progress.visibility = View.GONE
            }
        }

        weightViewModel.notesModel.observe(this) { weights ->
            setAdapter(weights)
        }

        binding.addWeights.setOnClickListener{
            startActivity(Intent(this@MainActivity, ABMWeightActivity::class.java))
        }

//        binding.addNotes.setOnClickListener{
//            startActivity(Intent(this@MainActivity, ABMNoteActivity::class.java))
//        }
    }

    override fun onResume() {
        super.onResume()
        weightViewModel.getWeights()
    }

    fun setAdapter(weights: MutableList<Weight>) {
        var adapter = WeightAdapter(weights)
        adapter.setClickListener(clickListener)
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerView.adapter = adapter
    }

    var clickListener = object: ClickListener {

        override fun onClickEdit(view: View, weight: Weight) {
            TODO("Not yet implemented")
        }

        override fun onClickDelete(view: View, weight: Weight) {
            TODO("Not yet implemented")
        }
    }
}