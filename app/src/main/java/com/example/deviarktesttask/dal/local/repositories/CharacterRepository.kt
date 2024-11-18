package com.example.deviarktesttask.dal.local.repositories

import com.example.deviarktesttask.dal.local.dao.CharacterDao
import com.example.deviarktesttask.dal.local.models.CharacterLocal

class CharacterRepository(private val characterDao: CharacterDao) {

    fun getCharacters(): List<CharacterLocal> {
        return characterDao.getCharacters()
    }

    fun insertCharacter(characterLocal: CharacterLocal) {
        characterDao.insertCharacter(characterLocal)
    }

    fun getCharacterById(id: String): CharacterLocal? {
        return characterDao.getCharacterById(id)
    }

    fun getCharacterByName(name: String): CharacterLocal? {
        return characterDao.getCharacterByName(name)
    }
}