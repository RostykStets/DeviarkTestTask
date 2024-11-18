package com.example.deviarktesttask.bll.local.services

import com.example.deviarktesttask.dal.CharactersSpells
import com.example.deviarktesttask.dal.Spell
import com.example.deviarktesttask.dal.local.models.SpellLocal

interface ICharactersSpellsService {

    fun upsert(charactersSpells: CharactersSpells)

    fun getSpellsByCharacter(characterId: String): List<Spell>

    fun getUnknownSpells(characterId:String): List<Spell>
}