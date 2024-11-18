package com.example.deviarktesttask.dal.local.repositories

import com.example.deviarktesttask.dal.local.dao.CharactersSpellsDao
import com.example.deviarktesttask.dal.local.models.CharactersSpellsLocal
import com.example.deviarktesttask.dal.local.models.SpellLocal

class CharactersSpellsRepository(private val charactersSpellsDao: CharactersSpellsDao) {

    fun upsert(charactersSpellsLocal: CharactersSpellsLocal){
        charactersSpellsDao.upsert(charactersSpellsLocal)
    }

    fun getSpellsByCharacter(characterId: String): List<SpellLocal> {
        return charactersSpellsDao.getSpellsByCharacter(characterId)
    }

    fun getUnknownSpells(characterId: String): List<SpellLocal> {
        return charactersSpellsDao.getUnknownSpells(characterId)
    }
}