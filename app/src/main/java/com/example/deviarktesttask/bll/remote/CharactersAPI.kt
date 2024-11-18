package com.example.deviarktesttask.bll.remote

import com.example.deviarktesttask.dal.Character
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class CharactersAPI {

    private val url = "https://hp-api.onrender.com/api/characters"

    suspend fun getAllCharacters(): List<Character> {
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()

        return withContext(Dispatchers.IO) {
            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val body = response.body?.string()
                val gson = Gson()
                val typeToken = object : TypeToken<List<Character>>() {}.type
                gson.fromJson(body, typeToken)
            } else {
                emptyList()
            }
        }
    }

    suspend fun getCharactersByHouse(house: String): List<Character> {
        val houseUrl = "${url}/house/$house"
        val client = OkHttpClient()
        val request = Request.Builder().url(houseUrl).build()

        return withContext(Dispatchers.IO) {
            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val body = response.body?.string()
                val gson = Gson()
                val typeToken = object : TypeToken<List<Character>>() {}.type
                gson.fromJson(body, typeToken)
            } else {
                emptyList()
            }
        }
    }
}