package com.jouw.package // PAS DIT AAN naar jouw eigen pakketnaam!

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var isFlowActive = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flowButton = findViewById<Button>(R.id.flowButton)
        val mainLayout = findViewById<RelativeLayout>(R.id.mainLayout)
        val statusText = findViewById<TextView>(R.id.statusText)
        val btnStats = findViewById<Button>(R.id.btnStats)

        // De Flow Switch
        flowButton.setOnClickListener {
            if (!isFlowActive) {
                isFlowActive = true
                mainLayout.setBackgroundColor(Color.parseColor("#1A237E")) // Deep Flow Blue
                flowButton.text = "STOP"
                flowButton.backgroundTintList = ColorStateList.valueOf(Color.DKGRAY)
                statusText.text = "You've entered the flow state."
                statusText.setTextColor(Color.WHITE)
            } else {
                isFlowActive = false
                mainLayout.setBackgroundColor(Color.parseColor("#F0F0F0"))
                flowButton.text = "START FLOW"
                flowButton.backgroundTintList = ColorStateList.valueOf(Color.RED)
                statusText.text = "Click here to enter the flow state. Reclaim your attention."
                statusText.setTextColor(Color.BLACK)
            }
        }

        // Statistieken knop
        btnStats.setOnClickListener {
            val prefs = getSharedPreferences("FlowStats", MODE_PRIVATE)
            val blockedCount = prefs.getInt("blocked_count", 0)
            statusText.text = "Je bent al $blockedCount keer gered van een scroll-site!"
            if (isFlowActive) statusText.setTextColor(Color.WHITE)
        }
    }
}