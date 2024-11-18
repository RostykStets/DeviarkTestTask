package com.example.deviarktesttask.dal.local.dao

import androidx.room.Dao
import androidx.room.Upsert
import com.example.deviarktesttask.dal.local.models.CharacterLocal

@Dao
interface CharacterDao {
    @Upsert
    suspend fun upsertCharacter(characterLocal: CharacterLocal)
}