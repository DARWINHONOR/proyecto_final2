package com.example.weight.ui.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.weight.R
import com.example.weight.data.entity.Weight
import com.example.weight.databinding.ActivityAbmweightBinding
import com.example.weight.ui.viewmodel.WeightViewModel
import java.util.*

class ABMWeightActivity : AppCompatActivity() {

    private val weightViewModel: WeightViewModel by viewModels()
    private lateinit var binding: ActivityAbmweightBinding
    private var weight: Weight? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbmweightBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_abmweight)
        setContentView(binding.root)

        if(intent.extras != null) {
            weight = intent.extras!!.getSerializable("weight") as Weight?
            binding.date.setText(weight?.date)
            weight?.weight?.let { binding.weight.setText(it) }
            binding.detail.setText(weight?.detail)
        }

        weightViewModel.init(this)
        weightViewModel.resultInsertNote.observe(this) { result ->
            finish()
        }
        weightViewModel.resultUpdateNote.observe(this) { resutl ->
            finish()
        }
        weightViewModel.resultDeleteNote.observe(this) { resutl ->
            finish()
        }

    }

    fun onClickSave(view: View) {
        if(weight == null) {
            weight = Weight(
                id = 0,
                date = binding.date.text.toString(),
                weight = Integer.parseInt(binding.weight.toString()),
                detail = binding.detail.text.toString(),
                status = 1
            )
            weightViewModel.insertWeight(weight!!)
        } else {
//            weight!!.date = binding.date.text.toString()
//            weight!!.detail = binding.detail.text.toString()
//            weight!!.weight = binding.weight.text
//            noteViewModel.updateNote(note!!)
        }
    }

//    fun onClickDelete(view: View){
//        noteViewModel.deleteNote(note!!)
//    }
}