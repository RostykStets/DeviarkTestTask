package com.example.deviarktesttask.dal.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.deviarktesttask.dal.local.models.Spell

@Dao
interface SpellDao {
    @Query("SELECT * FROM Spell")
    fun getSpells(): List<Spell>

    @Insert
    fun insertSpell(spell: Spell)

    @Query("SELECT * FROM Spell WHERE id = :id")
    fun getSpellById(id: String): Spell?

    @Query("SELECT * FROM Spell WHERE name = :name")
    fun getSpellByName(name: String): Spell?

    @Query("SELECT * FROM Spell WHERE description = :description")
    fun getSpellByDescription(description: String): Spell?
}