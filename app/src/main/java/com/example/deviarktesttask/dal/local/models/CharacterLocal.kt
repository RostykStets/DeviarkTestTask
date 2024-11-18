package com.example.deviarktesttask.dal.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CharacterLocal")
data class CharacterLocal(
    @PrimaryKey
    val id: String,
    val name: String
)
