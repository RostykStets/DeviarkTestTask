package com.example.deviarktesttask.dal.local.repositories

import com.example.deviarktesttask.dal.local.dao.SpellDao
import com.example.deviarktesttask.dal.local.models.Spell

class SpellRepository(private val spellDao: SpellDao) {

    fun getSpells(): List<Spell> {
        return spellDao.getSpells()
    }

    fun insertSpell(spell: Spell){
        spellDao.insertSpell(spell)
    }

    fun getSpellById(id: String): Spell? {
        return spellDao.getSpellById(id)
    }

    fun getSpellByName(name: String): Spell? {
        return spellDao.getSpellByName(name)
    }

    fun getSpellByDescription(description: String): Spell? {
        return spellDao.getSpellByDescription(description)
    }
}