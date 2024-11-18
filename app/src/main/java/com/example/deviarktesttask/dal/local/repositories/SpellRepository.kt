package com.example.deviarktesttask.dal.local.repositories

import com.example.deviarktesttask.dal.local.dao.SpellDao
import com.example.deviarktesttask.dal.local.models.SpellLocal

class SpellRepository(private val spellDao: SpellDao) {

    fun getSpells(): List<SpellLocal> {
        return spellDao.getSpells()
    }

    fun insertSpell(spellLocal: SpellLocal){
        spellDao.insertSpell(spellLocal)
    }

    fun getSpellById(id: String): SpellLocal? {
        return spellDao.getSpellById(id)
    }

    fun getSpellByName(name: String): SpellLocal? {
        return spellDao.getSpellByName(name)
    }

    fun getSpellByDescription(description: String): SpellLocal? {
        return spellDao.getSpellByDescription(description)
    }
}