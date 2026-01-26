package com.antioverstimul2

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Haal de opgeslagen statistiek op
        val prefs = getSharedPreferences("AntiScrollPrefs", Context.MODE_PRIVATE)
        val count = prefs.getInt("block_count", 0)

        // Laat de teller zien
        val statText = findViewById<TextView>(R.id.blockCounter)
        statText.text = "Totaal aantal blokkades: $count"
    }
}