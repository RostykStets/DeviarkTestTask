package com.example.deviarktesttask.dal.local.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(
    entity = CharacterLocal::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("characterId"),
    onUpdate = ForeignKey.CASCADE,
    onDelete = ForeignKey.CASCADE
),
ForeignKey(
    entity = SpellLocal::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("spellId"),
    onUpdate = ForeignKey.CASCADE,
    onDelete = ForeignKey.CASCADE
)])
data class CharactersSpellsLocal(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val characterId: String,
    val spellId: String
)