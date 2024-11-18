package com.example.deviarktesttask.dal

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Spell(
    val id: String,
    val name: String,
    val description: String) : Parcelable
