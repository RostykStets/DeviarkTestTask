package com.example.deviarktesttask.dal

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val id: String,
    val name: String,
    val alternateNames: List<String>?,
    val species: String,
    val gender: String,
    val house: String,
    val dateOfBirth: String?,
    val yearOfBirth: Int?,
    val wizard: Boolean,
    val ancestry: String,
    val eyeColour: String,
    val hairColour: String,
    val wand: Wand,
    val patronus: String,
    val hogwartsStudent: Boolean,
    val hogwartsStaff: Boolean,
    val actor: String,
    val alternateActors: List<String>?,
    val alive: Boolean,
    val image: String
) : Parcelable