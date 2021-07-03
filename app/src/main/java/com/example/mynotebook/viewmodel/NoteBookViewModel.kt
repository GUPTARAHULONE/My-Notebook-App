package com.example.mynotebook.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynotebook.model.NoteBook
import com.example.mynotebook.repository.NotebookRepo
import kotlinx.coroutines.launch

class NoteBookViewModel:ViewModel() {

    val repo=NotebookRepo()
    val list=MutableLiveData<List<NoteBook>>()

    fun insert(context: Context,noteBook: NoteBook){
        viewModelScope.launch{
                repo.insert(context, noteBook)
        }
    }

    fun delete(context: Context,notebook:NoteBook){
        viewModelScope.launch {
            repo.delete(context,notebook)
            list.value=repo.getAllNotebooks(context)
        }
    }
    fun getAllNotebooks(context: Context){
        viewModelScope.launch {
            list.value=  repo.getAllNotebooks(context)
        }
    }

}