package com.example.deviarktesttask.bll.local.implementations

import com.example.deviarktesttask.bll.local.services.ICharactersSpellsService
import com.example.deviarktesttask.dal.CharactersSpells
import com.example.deviarktesttask.dal.Spell
import com.example.deviarktesttask.dal.local.models.CharactersSpellsLocal
import com.example.deviarktesttask.dal.local.repositories.CharactersSpellsRepository

class CharactersSpellsService(private val charactersSpellsRepository: CharactersSpellsRepository): ICharactersSpellsService {
    override suspend fun upsert(charactersSpells: CharactersSpells) {
        val charactersSpellsLocal = CharactersSpellsLocal(0, charactersSpells.characterId, charactersSpells.spellId)
        charactersSpellsRepository.upsert(charactersSpellsLocal)
    }

    override suspend fun getSpellsByCharacter(characterId: String): List<Spell> {
        val spellsLocal = charactersSpellsRepository.getSpellsByCharacter(characterId)
        val spells: MutableList<Spell> = mutableListOf()
        for(spellLocal in spellsLocal){
            spells.add(Spell(spellLocal.id, spellLocal.name, spellLocal.description))
        }
        return spells.toList()
    }

    override suspend fun getUnknownSpells(characterId:String): List<Spell> {
        val spellsLocal = charactersSpellsRepository.getUnknownSpells(characterId)
        val spells: MutableList<Spell> = mutableListOf()
        for(spellLocal in spellsLocal){
            spells.add(Spell(spellLocal.id, spellLocal.name, spellLocal.description))
        }
        return spells.toList()
    }
}