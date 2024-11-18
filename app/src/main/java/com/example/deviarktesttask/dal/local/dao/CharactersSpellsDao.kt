package com.example.deviarktesttask.dal.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.deviarktesttask.dal.local.models.CharactersSpells
import com.example.deviarktesttask.dal.local.models.SpellLocal

@Dao
interface CharactersSpellsDao {
    @Insert
    fun insert(charactersSpells: CharactersSpells)

    @Query("SELECT * FROM SpellLocal JOIN CharactersSpells ON SpellLocal.id == CharactersSpells.spellId WHERE CharactersSpells.characterId = :characterId")
    fun getSpellsByCharacter(characterId: String): List<SpellLocal>
}