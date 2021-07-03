package com.example.mynotebook.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mynotebook.model.NoteBook


@Database(entities = arrayOf(NoteBook::class),version = 1,exportSchema = false)
abstract class NoteBookDatabase :RoomDatabase() {

    companion object{
        fun get(context: Context): NoteBookDatabase {
            return Room.databaseBuilder(context, NoteBookDatabase::class.java,"note").build()
        }
    }

    abstract fun getNotebookDao():NoteBookDAO
}