package com.example.mynotebook.repository

import android.content.Context
import com.example.mynotebook.model.NoteBook
import com.example.mynotebook.room.NoteBookDatabase

class NotebookRepo {

    suspend fun insert(context: Context, noteBook: NoteBook){
        NoteBookDatabase.get(context).getNotebookDao().insert(noteBook)
    }
    suspend fun delete(context: Context, noteBook: NoteBook){
        NoteBookDatabase.get(context).getNotebookDao().delete(noteBook)
    }
    suspend fun getAllNotebooks(context: Context):List<NoteBook>{
        return  NoteBookDatabase.get(context).getNotebookDao().getAllNotebook()
    }
}