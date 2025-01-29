package com.example.notesapp.repos

import androidx.lifecycle.LiveData
import com.example.notesapp.DAO.notesDAO
import com.example.notesapp.model.entity

class notesRepo(val dao: notesDAO) {

    fun getallnotes(): LiveData<List<entity>> {
        return dao.getalldata()
    }

    fun insertnote(note: entity) {
        dao.insert(note)
    }

    fun deletenote(id:Int){
     dao.delete(id)
    }

    fun updatenote(note: entity){
         dao.update(note)
    }
}