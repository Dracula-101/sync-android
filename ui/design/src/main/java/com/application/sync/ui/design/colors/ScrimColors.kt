package com.application.sync.ui.design.colors

import androidx.compose.ui.graphics.Color
import com.application.sync.ui.design.utils.ColorGenerators


/**
 * Represents scrim colors used in the application.
 * * @property color The primary scrim color.
 * * This color is typically used for overlays or dimming effects.
 */
data class ScrimColors(
    val color: Color,
    private val shades: ColorShades = ColorGenerators.generateShades(color)
) : ColorShades by shades