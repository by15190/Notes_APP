package com.example.notesapp.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.notesapp.model.entity

@Dao
interface notesDAO {

    @Query("SELECT * FROM NOTES")
    fun getalldata(): LiveData<List<entity>>


    @Insert(entity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: entity)

    @Query( "DELETE FROM NOTES WHERE id=:id ")
    fun delete(id:Int)

    @Update()
    fun update(note: entity)


}