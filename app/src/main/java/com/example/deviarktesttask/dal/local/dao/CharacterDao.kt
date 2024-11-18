package com.example.deviarktesttask.dal.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.deviarktesttask.dal.local.models.CharacterLocal

@Dao
interface CharacterDao {
    @Query("SELECT * FROM CharacterLocal")
    suspend fun getCharacters(): List<CharacterLocal>

    @Insert
    suspend fun insertCharacter(characterLocal: CharacterLocal)

    @Query("SELECT * FROM CharacterLocal WHERE id = :id")
    suspend fun getCharacterById(id: String): CharacterLocal?

    @Query("SELECT * FROM CharacterLocal WHERE name = :name")
    suspend fun getCharacterByName(name: String): CharacterLocal?
}