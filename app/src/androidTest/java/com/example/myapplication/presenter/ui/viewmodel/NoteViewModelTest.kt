package com.example.myapplication.presenter.ui.viewmodel

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.myapplication.db.NoteEntity
import com.example.myapplication.db.NoteRoomDatabase
import com.example.myapplication.domain.repository.NoteRepo
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.mindrot.jbcrypt.BCrypt

class NoteViewModelTest {

    lateinit var viewModel: NoteViewModel

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val db = Room.inMemoryDatabaseBuilder(context, NoteRoomDatabase::class.java)
           .build()
        val noteDao = db.noteDao()
        val noteRepo = NoteRepo(noteDao)
        viewModel = NoteViewModel(noteRepo)
    }

    @Test
    fun testViewModel() {
        viewModel.insertNote(
            NoteEntity(
                title = "Test Note",
                subTitle = "Test SubTitle",
                author = "author",
                hashPassword = BCrypt.hashpw("12345678", BCrypt.gensalt()),
                content = "Test Content"
            )
        )
        viewModel.get()
        val result = viewModel.getdata.getOrAwaitValue().find {
            it.title == "Test Note"
        }
        assertThat(result != null).isTrue()
    }


}