package com.example.deviarktesttask.dal.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.deviarktesttask.dal.local.models.Character

@Dao
interface CharacterDao {
    @Query("SELECT * FROM Character")
    fun getCharacters(): List<Character>

    @Insert
    fun insertCharacter(character: Character)

    @Query("SELECT * FROM Character WHERE id = :id")
    fun getCharacterById(id: String): Character?

    @Query("SELECT * FROM Character WHERE name = :name")
    fun getCharacterByName(name: String): Character?
}