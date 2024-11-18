package com.example.deviarktesttask.bll.local.implementations

import com.example.deviarktesttask.bll.local.services.ISpellService
import com.example.deviarktesttask.dal.Spell
import com.example.deviarktesttask.dal.local.models.SpellLocal
import com.example.deviarktesttask.dal.local.repositories.SpellRepository

class SpellService(private val spellRepository: SpellRepository): ISpellService {
    override suspend fun upsertSpell(spell: Spell) {
        val newSpell = SpellLocal(spell.id, spell.name, spell.description)
        spellRepository.upsertSpell(newSpell)
    }
}