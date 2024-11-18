package com.example.deviarktesttask.dal.local.repositories

import com.example.deviarktesttask.dal.local.dao.CharactersSpellsDao
import com.example.deviarktesttask.dal.local.models.CharactersSpells
import com.example.deviarktesttask.dal.local.models.SpellLocal

class CharactersSpellsRepository(private val charactersSpellsDao: CharactersSpellsDao) {

    fun insert(charactersSpells: CharactersSpells){
        charactersSpellsDao.insert(charactersSpells)
    }

    fun getSpellsByCharacter(characterId: String): List<SpellLocal> {
        return charactersSpellsDao.getSpellsByCharacter(characterId)
    }
}