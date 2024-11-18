package com.example.deviarktesttask.dal.local.dao

import androidx.room.Dao
import androidx.room.Upsert
import com.example.deviarktesttask.dal.local.models.SpellLocal

@Dao
interface SpellDao {
    @Upsert
    suspend fun upsertSpell(spellLocal: SpellLocal)
}