package com.example.deviarktesttask.dal.local.repositories

import com.example.deviarktesttask.dal.local.dao.CharactersSpellsDao
import com.example.deviarktesttask.dal.local.models.CharactersSpellsLocal
import com.example.deviarktesttask.dal.local.models.SpellLocal

class CharactersSpellsRepository(private val charactersSpellsDao: CharactersSpellsDao) {

    suspend fun upsert(charactersSpellsLocal: CharactersSpellsLocal){
        charactersSpellsDao.upsert(charactersSpellsLocal)
    }

    suspend fun getSpellsByCharacter(characterId: String): List<SpellLocal> {
        return charactersSpellsDao.getSpellsByCharacter(characterId)
    }

    suspend fun getUnknownSpells(characterId: String): List<SpellLocal> {
        return charactersSpellsDao.getUnknownSpells(characterId)
    }

    suspend fun getLearnedSpells(characterId: String): List<SpellLocal> {
        return charactersSpellsDao.getLearnedSpells(characterId)
    }
}