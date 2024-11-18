package com.example.deviarktesttask.dal.local

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.deviarktesttask.dal.local.dao.CharacterDao
import com.example.deviarktesttask.dal.local.dao.SpellDao
import com.example.deviarktesttask.dal.local.models.Character
import com.example.deviarktesttask.dal.local.models.Spell

@Database(entities = [Character::class, Spell::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun spellDao(): SpellDao
}