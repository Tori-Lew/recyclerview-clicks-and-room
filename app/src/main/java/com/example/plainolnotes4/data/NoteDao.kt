package com.example.plainolnotes4.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: NoteEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(notes: List<NoteEntity>)

    @Query("SELECT * FROM notes ORDER BY date ASC")
    fun getAll(): LiveData<List<NoteEntity>>

    @Query ("SELECT * FROM notes WHERE id = :id")
    fun getNoteByID(id:Int):NoteEntity?

    @Query("SELECT COUNT(*) from notes")
    fun getCount(): Int
}