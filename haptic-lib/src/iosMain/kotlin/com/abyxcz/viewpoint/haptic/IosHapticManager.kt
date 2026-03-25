package com.abyxcz.viewpoint.haptic

import platform.UIKit.UIImpactFeedbackGenerator
import platform.UIKit.UIImpactFeedbackStyle

class IosHapticManager : HapticManager {
    private var generator: UIImpactFeedbackGenerator? = null

    override fun pulse(intensity: Float) {
        val style = when {
            intensity > 0.8f -> UIImpactFeedbackStyle.UIImpactFeedbackStyleHeavy
            intensity > 0.4f -> UIImpactFeedbackStyle.UIImpactFeedbackStyleMedium
            else -> UIImpactFeedbackStyle.UIImpactFeedbackStyleLight
        }
        
        generator = UIImpactFeedbackGenerator(style = style)
        generator?.prepare()
        generator?.impactOccurred()
    }

    override fun stop() {
        generator = null
    }
}
