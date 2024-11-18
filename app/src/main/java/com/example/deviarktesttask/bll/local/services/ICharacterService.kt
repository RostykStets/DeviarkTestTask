package com.example.deviarktesttask.bll.local.services

import com.example.deviarktesttask.dal.Character

interface ICharacterService {

    suspend fun upsertCharacter(character: Character)
}