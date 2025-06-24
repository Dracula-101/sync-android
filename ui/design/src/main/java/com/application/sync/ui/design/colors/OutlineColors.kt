package com.application.sync.ui.design.colors

import androidx.compose.ui.graphics.Color
import com.application.sync.ui.design.utils.ColorGenerators

/**
 * Represents the outline colors used in the application.
 *
 * @property color The primary outline color.
 */
data class OutlineColors(
    val color: Color,
    val variant: Color,
    private val shades: ColorShades = ColorGenerators.generateShades(color)
) : ColorShades by shades