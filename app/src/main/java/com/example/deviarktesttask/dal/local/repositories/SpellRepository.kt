package com.example.deviarktesttask.dal.local.repositories

import com.example.deviarktesttask.dal.local.dao.SpellDao
import com.example.deviarktesttask.dal.local.models.SpellLocal

class SpellRepository(private val spellDao: SpellDao) {

    suspend fun upsertSpell(spellLocal: SpellLocal){
        spellDao.upsertSpell(spellLocal)
    }
}