package com.example.deviarktesttask.bll.local.services

import com.example.deviarktesttask.dal.Spell

interface ISpellService {
    suspend fun upsertSpell(spell: Spell)
}