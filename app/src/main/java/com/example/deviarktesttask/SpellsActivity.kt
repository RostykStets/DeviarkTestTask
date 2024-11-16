package com.example.deviarktesttask

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.deviarktesttask.databinding.ActivitySpellsBinding
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class SpellsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySpellsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpellsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val url = "https://hp-api.onrender.com/api/spells"

        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.stackTrace
                setText(binding.spells, e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) {
                        setText(binding.spells,"Something went wrong with request!")
                    }
                    else{
                        val body = response.body?.string()
                        setText(binding.spells, body.toString())
                    }
                }
            }
        })

    }

    private fun setText(text: TextView, value: String) {
        runOnUiThread { text.text = value }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}