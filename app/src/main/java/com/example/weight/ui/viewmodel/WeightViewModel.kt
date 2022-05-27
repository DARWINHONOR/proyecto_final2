package com.example.weight.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weight.data.entity.Weight
import com.example.weight.domain.GetAllWeights
import com.example.weight.domain.InsertWeight
import kotlinx.coroutines.launch

class WeightViewModel : ViewModel(){

    lateinit var getAllWeights: GetAllWeights
    lateinit var insertsWeight: InsertWeight
//    lateinit var updatedNote: UpdateNote
//    lateinit var deletedNote: DeleteNote

    val loading = MutableLiveData<Boolean>()
    val resultInsertNote = MutableLiveData<Boolean>()
    val resultUpdateNote = MutableLiveData<Boolean>()
    val noteModel = MutableLiveData<Weight>()
    val notesModel = MutableLiveData<MutableList<Weight>>().apply { postValue(mutableListOf()) }
    val resultDeleteNote = MutableLiveData<Boolean>()

    fun init(context: Context) {
        this.getAllWeights = GetAllWeights(context)
        this.insertsWeight = InsertWeight(context)
//        this.updatedNote = UpdateNote(context)
//        this.deletedNote = DeleteNote(context)
    }

    fun getWeights() {
        viewModelScope.launch {
            loading.postValue(true)
            notesModel.postValue(getAllWeights())
            loading.postValue(false)
        }
    }

    fun insertWeight(weight: Weight) {
        viewModelScope.launch {
            loading.postValue(true)
            var result = insertsWeight(weight)
            resultInsertNote.postValue(result)
            loading.postValue(false)
        }
    }

//    fun updateNote(note: Note) {
//        viewModelScope.launch {
//            var result = updatedNote(note)
//            resultUpdateNote.postValue(result)
//        }
//    }
//
//    fun deleteNote(note: Note) {
//        viewModelScope.launch {
//            var result = deletedNote(note)
//            resultDeleteNote.postValue(result)
//        }
//    }
}