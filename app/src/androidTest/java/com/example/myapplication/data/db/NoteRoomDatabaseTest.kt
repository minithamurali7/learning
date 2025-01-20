package com.example.myapplication.data.db

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.myapplication.db.NoteDao
import com.example.myapplication.db.NoteEntity
import com.example.myapplication.db.NoteRoomDatabase
import com.google.common.truth.Truth.assertThat

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mindrot.jbcrypt.BCrypt

class NoteRoomDatabaseTest {

    private lateinit var db: NoteRoomDatabase
    private lateinit var dao: NoteDao

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, NoteRoomDatabase::class.java).build()
        dao = db.noteDao()
    }

    @Test
    fun writeRead() {

        val note = NoteEntity(
            title = "Ram c/o Anandhi11",
            subTitle = "Novel11",
            content = "it is thriller romantic story11",
            author = "Akhil p dev11",
            hashPassword = BCrypt.hashpw("123456", BCrypt.gensalt())
        )
        dao.AddNote(note)

        val list = dao.getNotes()
      //  assertThat(list.value?.contains(note)).isTrue()


    }

    @After
    fun closeDb() {
        db.close()
    }
}