package com.example.myapplication.presenter.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.db.NoteEntity
import com.example.myapplication.domain.repository.NoteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val noteRepo: NoteRepo) : ViewModel() {

    val _getdata = MutableLiveData<List<NoteEntity>>()
    val getdata: LiveData<List<NoteEntity>> = _getdata
    fun insertNote(note: NoteEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            noteRepo.addNote(note)
        }

    }

    fun get()=
        viewModelScope.launch {
            _getdata.value  = noteRepo.getAllNotes()
        }
}