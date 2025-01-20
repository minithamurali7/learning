package com.example.myapplication.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.db.NoteDao
import com.example.myapplication.db.NoteEntity
import javax.inject.Inject

class NoteRepo @Inject constructor(val noteDao: NoteDao){

    fun getAllNotes() : List<NoteEntity>{
        return noteDao.getNotes()
    }

    fun addNote(note:NoteEntity){
        noteDao.AddNote(note)
    }

}