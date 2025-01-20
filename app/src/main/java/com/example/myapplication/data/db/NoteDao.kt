package com.example.myapplication.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface NoteDao {

    @Insert
     fun AddNote(note: NoteEntity)

    @Query("SELECT * FROM notes")
     fun getNotes(): List<NoteEntity>
}