package com.example.deviarktesttask.dal.local.repositories

import com.example.deviarktesttask.dal.local.dao.CharacterDao
import com.example.deviarktesttask.dal.local.models.CharacterLocal

class CharacterRepository(private val characterDao: CharacterDao) {
    suspend fun upsertCharacter(characterLocal: CharacterLocal) {
        characterDao.upsertCharacter(characterLocal)
    }
}