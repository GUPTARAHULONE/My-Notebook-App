package com.example.mynotebook.adapters

import com.example.mynotebook.model.NoteBook

interface ClickHandler {

    fun handleLongClick(noteBook: NoteBook)

    fun handleClick(noteBook: NoteBook)
}