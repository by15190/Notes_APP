package com.example.notesapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesapp.DAO.notesDAO
import com.example.notesapp.model.entity


@Database(entities = [entity::class], version = 1, exportSchema = false)
abstract class notesDatabase : RoomDatabase() {

    abstract fun mynotesdao(): notesDAO

    companion object { // like an object to access the class without creating object
        @Volatile // to access easily
        var INSTANCE: notesDatabase? = null // to access the database

        fun getDatabaseInstance(context: Context): notesDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this)
            {
                val roomDatabaseinstance =
                    Room.databaseBuilder(context, notesDatabase::class.java, "notes").allowMainThreadQueries().build()
                INSTANCE = roomDatabaseinstance
                return roomDatabaseinstance
            }


        }

    }
}