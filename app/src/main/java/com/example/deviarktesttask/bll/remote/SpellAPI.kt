package com.example.deviarktesttask.bll.remote

import com.example.deviarktesttask.dal.Spell
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class SpellAPI {
    private val url = "https://hp-api.onrender.com/api/spells"

    suspend fun getAllSpells(): List<Spell>{
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()

        return withContext(Dispatchers.IO) {
            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val body = response.body?.string()
                val gson = Gson()
                val typeToken = object : TypeToken<List<Spell>>() {}.type
                gson.fromJson(body, typeToken)
            } else {
                emptyList()
            }
        }
    }
}