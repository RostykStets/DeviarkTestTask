package com.example.deviarktesttask.dal.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Spell(
    @PrimaryKey
    val id: String,
    val name: String,
    val description: String
)
