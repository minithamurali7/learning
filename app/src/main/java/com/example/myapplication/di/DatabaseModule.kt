package com.example.myapplication.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.myapplication.db.NoteDao
import com.example.myapplication.db.NoteRoomDatabase
import com.example.myapplication.domain.repository.NoteRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // Add the new column `priority`
            database.execSQL("ALTER TABLE notes ADD COLUMN author STRING")
        }
    }

    val MIGRATION_2_3 = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // Add the new column `priority`
            database.execSQL("ALTER TABLE notes ADD COLUMN subTitle TEXT NOT NULL DEFAULT ''")
        }
    }

    val MIGRATION_3_4 = object : Migration(3, 4) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // Add the new column `priority`
            database.execSQL("ALTER TABLE notes ADD COLUMN hashPassword TEXT NOT NULL DEFAULT ''")
        }
    }

    val array = arrayOf(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4)

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): NoteRoomDatabase {
        return Room.databaseBuilder(
            context,
            NoteRoomDatabase::class.java,
            "note_database"
        )
            .addMigrations(array[2])
            .build()
    }

    @Provides
    fun provideDao(database: NoteRoomDatabase): NoteDao {
        return database.noteDao()
    }

    @Provides
    fun provideNoteRepo(noteDao: NoteDao): NoteRepo {
        return NoteRepo(noteDao)
    }



}