package com.jouw.package // PAS DIT AAN naar jouw eigen pakketnaam!

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

class AntiScrollService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        // 1. Energiebesparing: Alleen scannen bij YouTube of Browsers
        val packageName = event.packageName?.toString() ?: ""
        val targetApps = listOf("youtube", "chrome", "browser", "tiktok", "instagram")
        if (targetApps.none { packageName.contains(it) }) return

        // 2. Scan het scherm
        val rootNode = rootInActiveWindow ?: return
        
        // Detecteer scroll-elementen (likes/abonneer/shorts)
        val hasLike = findNodeByText(rootNode, "like") || findNodeByText(rootNode, "vind ik leuk")
        val hasSubscribe = findNodeByText(rootNode, "subscribe") || findNodeByText(rootNode, "abonneren")
        val isShorts = findNodeByText(rootNode, "Shorts")

        // 3. De Onverbiddelijke Blokkade
        if (isShorts || (hasLike && hasSubscribe)) {
            // Sla statistiek op
            val prefs = getSharedPreferences("FlowStats", MODE_PRIVATE)
            val currentCount = prefs.getInt("blocked_count", 0)
            prefs.edit().putInt("blocked_count", currentCount + 1).apply()

            // Gooi gebruiker terug
            performGlobalAction(GLOBAL_ACTION_BACK)
        }
    }

    private fun findNodeByText(node: AccessibilityNodeInfo, text: String): Boolean {
        val nodes = node.findAccessibilityNodeInfosByText(text)
        return nodes != null && nodes.isNotEmpty()
    }

    override fun onInterrupt() {}
}