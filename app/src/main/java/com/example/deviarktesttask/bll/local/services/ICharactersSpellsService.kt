package com.example.deviarktesttask.bll.local.services

import com.example.deviarktesttask.dal.CharactersSpells
import com.example.deviarktesttask.dal.Spell

interface ICharactersSpellsService {

    suspend fun upsert(charactersSpells: CharactersSpells)

    suspend fun getSpellsByCharacter(characterId: String): List<Spell>

    suspend fun getUnknownSpells(characterId:String): List<Spell>

    suspend fun getLearnedSpells(characterId: String): List<Spell>
}