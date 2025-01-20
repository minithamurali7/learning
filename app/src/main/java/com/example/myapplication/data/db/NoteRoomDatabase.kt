package com.example.myapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Database(entities = [NoteEntity::class], version =4 , exportSchema = false)
abstract class NoteRoomDatabase : RoomDatabase(){

     abstract fun noteDao() : NoteDao

}