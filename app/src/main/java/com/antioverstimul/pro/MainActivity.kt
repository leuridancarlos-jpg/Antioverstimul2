package com.antioverstimul.pro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.LinearLayout
import android.graphics.Color
import android.view.Gravity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.parseColor("#F5F7FA"))
            gravity = Gravity.CENTER
            setPadding(50, 50, 50, 50)
        }

        val title = TextView(this).apply {
            text = "Antioverstimul Pro"
            textSize = 28f
            setTextColor(Color.parseColor("#2C3E50"))
            gravity = Gravity.CENTER
        }

        val description = TextView(this).apply {
            text = "\nFocus Modus is actief.\n\nWij scannen op scroll-knoppen om je rust te bewaren."
            textSize = 18f
            setTextColor(Color.parseColor("#7F8C8D"))
            gravity = Gravity.CENTER
        }

        layout.addView(title)
        layout.addView(description)
        setContentView(layout)
    }
}