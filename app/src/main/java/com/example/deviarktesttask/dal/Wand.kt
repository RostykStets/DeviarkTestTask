package com.example.deviarktesttask.dal


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wand(
    val wood: String,
    val core: String,
    val length: Double) : Parcelable
