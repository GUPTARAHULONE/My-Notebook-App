package com.example.mynotebook.room

import androidx.room.*
import com.example.mynotebook.model.NoteBook


@Dao
interface NoteBookDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(noteBook: NoteBook)

    @Delete
    suspend fun delete(noteBook: NoteBook)

    @Query("SELECT * FROM NoteBook")
    suspend fun getAllNotebook():List<NoteBook>

}