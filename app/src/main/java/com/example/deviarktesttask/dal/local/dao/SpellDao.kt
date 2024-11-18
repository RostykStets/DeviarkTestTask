package com.example.deviarktesttask.dal.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.example.deviarktesttask.dal.local.models.SpellLocal

@Dao
interface SpellDao {
    @Query("SELECT * FROM SpellLocal")
    suspend fun getSpells(): List<SpellLocal>

    @Upsert
    fun upsertSpell(spellLocal: SpellLocal)

    @Query("SELECT * FROM SpellLocal WHERE id = :id")
    fun getSpellById(id: String): SpellLocal?

    @Query("SELECT * FROM SpellLocal WHERE name = :name")
    fun getSpellByName(name: String): SpellLocal?

    @Query("SELECT * FROM SpellLocal WHERE description = :description")
    fun getSpellByDescription(description: String): SpellLocal?
}