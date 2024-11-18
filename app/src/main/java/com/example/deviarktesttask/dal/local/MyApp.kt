package com.example.deviarktesttask.dal.local

import android.app.Application
import androidx.room.Room
import com.example.deviarktesttask.dal.local.dao.CharacterDao
import com.example.deviarktesttask.dal.local.dao.CharactersSpellsDao
import com.example.deviarktesttask.dal.local.dao.SpellDao

class MyApp: Application() {

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "harrypotter_db").build()
    }

    fun getCharacterDao(): CharacterDao {
        return database.characterDao()
    }

    fun getSpellDao(): SpellDao {
        return database.spellDao()
    }

    fun getCharactersSpellsDao(): CharactersSpellsDao{
        return database.charactersSpellsDao()
    }
}