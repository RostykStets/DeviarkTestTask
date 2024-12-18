package com.example.deviarktesttask.dal.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.deviarktesttask.dal.local.models.CharactersSpellsLocal
import com.example.deviarktesttask.dal.local.models.SpellLocal

@Dao
interface CharactersSpellsDao {
    @Upsert
    suspend fun upsert(charactersSpellsLocal: CharactersSpellsLocal)

    @Query("SELECT * FROM SpellLocal JOIN CharactersSpellsLocal ON SpellLocal.id == CharactersSpellsLocal.spellId WHERE CharactersSpellsLocal.characterId = :characterId")
    suspend fun getSpellsByCharacter(characterId: String): List<SpellLocal>

    @Query("""
        SELECT s.*
        FROM SpellLocal s
        WHERE s.Id NOT IN (
        SELECT cs.spellId
        FROM CharactersSpellsLocal cs
        WHERE cs.characterId = :characterId)
    """)
    suspend fun getUnknownSpells(characterId:String): List<SpellLocal>

    @Query("""
        SELECT s.*
        FROM SpellLocal s
        WHERE s.Id IN (
        SELECT cs.spellId
        FROM CharactersSpellsLocal cs
        WHERE cs.characterId = :characterId)
    """)
    suspend fun getLearnedSpells(characterId: String): List<SpellLocal>
}