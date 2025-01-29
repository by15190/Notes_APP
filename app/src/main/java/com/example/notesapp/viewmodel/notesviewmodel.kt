package com.example.notesapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notesapp.database.notesDatabase
import com.example.notesapp.model.entity
import com.example.notesapp.repos.notesRepo

class notesviewmodel(application: Application) : AndroidViewModel(application) {

    val repo: notesRepo

    init {
        val dao = notesDatabase.getDatabaseInstance(application).mynotesdao() // get the dao
        repo = notesRepo(dao)  // get the repo with dao as parameter
    }

    fun addnote(note: entity) {
        repo.insertnote(note)
    }

    fun getallnotes(): LiveData<List<entity>> {
        return repo.getallnotes()
    }

    fun deletenotes(id: Int) {
        repo.deletenote(id)
    }

    fun updatenotes(note: entity) {
        repo.updatenote(note)
    }

}