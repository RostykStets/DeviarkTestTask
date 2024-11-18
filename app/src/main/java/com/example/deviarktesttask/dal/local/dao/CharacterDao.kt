package com.example.deviarktesttask.dal.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.deviarktesttask.dal.local.models.CharacterLocal

@Dao
interface CharacterDao {
    @Query("SELECT * FROM CharacterLocal")
    fun getCharacters(): List<CharacterLocal>

    @Insert
    fun insertCharacter(characterLocal: CharacterLocal)

    @Query("SELECT * FROM CharacterLocal WHERE id = :id")
    fun getCharacterById(id: String): CharacterLocal?

    @Query("SELECT * FROM CharacterLocal WHERE name = :name")
    fun getCharacterByName(name: String): CharacterLocal?
}