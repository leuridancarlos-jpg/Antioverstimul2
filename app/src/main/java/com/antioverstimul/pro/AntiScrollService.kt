package com.antioverstimul.pro

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

class AntiScrollService : AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        val rootNode = rootInActiveWindow ?: return
        
        // Scant op woorden die duiden op verslavende korte video's
        val triggerButtons = rootNode.findAccessibilityNodeInfosByText("Abonneer")
            .plus(rootNode.findAccessibilityNodeInfosByText("Like"))
            .plus(rootNode.findAccessibilityNodeInfosByText("Shorts"))

        if (triggerButtons.isNotEmpty()) {
            // Actie: stuur de gebruiker direct terug
            performGlobalAction(GLOBAL_ACTION_BACK)
        }
    }

    override fun onInterrupt() {}
}
