package com.example.deviarktesttask.bll.local.implementations

import com.example.deviarktesttask.bll.local.services.ICharacterService
import com.example.deviarktesttask.dal.Character
import com.example.deviarktesttask.dal.local.models.CharacterLocal
import com.example.deviarktesttask.dal.local.repositories.CharacterRepository

class CharacterService(private val characterRepository: CharacterRepository): ICharacterService {

    override suspend fun upsertCharacter(character: Character) {
        characterRepository.upsertCharacter(CharacterLocal(character.id, character.name))
    }
}