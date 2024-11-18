package com.example.deviarktesttask.dal.local.repositories

import com.example.deviarktesttask.dal.local.dao.CharacterDao
import com.example.deviarktesttask.dal.local.models.Character

class CharacterRepository(private val characterDao: CharacterDao) {

    fun getCharacters(): List<Character> {
        return characterDao.getCharacters()
    }

    fun insertCharacter(character: Character) {
        characterDao.insertCharacter(character)
    }

    fun getCharacterById(id: String): Character? {
        return characterDao.getCharacterById(id)
    }

    fun getCharacterByName(name: String): Character? {
        return characterDao.getCharacterByName(name)
    }
}