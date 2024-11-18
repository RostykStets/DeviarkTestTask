package com.example.deviarktesttask.dal.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.deviarktesttask.dal.local.dao.CharacterDao
import com.example.deviarktesttask.dal.local.dao.CharactersSpellsDao
import com.example.deviarktesttask.dal.local.dao.SpellDao
import com.example.deviarktesttask.dal.local.models.CharacterLocal
import com.example.deviarktesttask.dal.local.models.CharactersSpellsLocal
import com.example.deviarktesttask.dal.local.models.SpellLocal

@Database(entities = [CharacterLocal::class, SpellLocal::class, CharactersSpellsLocal::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun spellDao(): SpellDao
    abstract fun charactersSpellsDao(): CharactersSpellsDao
}