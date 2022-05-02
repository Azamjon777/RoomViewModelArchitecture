package com.example.sqlroomkotlin.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.sqlroomkotlin.REPOSITORY
import com.example.sqlroomkotlin.db.NoteDatabase
import com.example.sqlroomkotlin.db.repository.NoteRealization
import com.example.sqlroomkotlin.db.repository.NoteRepository
import com.example.sqlroomkotlin.model.NoteModel

class StartViewModel(application: Application) : AndroidViewModel(application) {
    private val context = application

    fun initDatabase() {
        val noteDao = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(noteDao)
    }

    fun getAllNotes(): LiveData<List<NoteModel>>{
        return REPOSITORY.allNotes
    }

}