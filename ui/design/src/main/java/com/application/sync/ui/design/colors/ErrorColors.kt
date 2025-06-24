package com.application.sync.ui.design.colors

import androidx.compose.ui.graphics.Color
import com.application.sync.ui.design.utils.ColorAlphaData
import com.application.sync.ui.design.utils.ColorGenerators

/**
 * Represents a complete color scheme for the application.
 *
 * @property color The main error color.
 * @property onColor The contrasting color for text/icons on the error color.
 * @property container The container color for error states.
 * @property onContainer The contrasting color for text/icons on the error container.
 */
data class ErrorColors(
    val color: Color,
    val onColor: Color,
    val container: Color,
    val onContainer: Color,
    private val alphas: ColorAlphaData = ColorGenerators.generateAlpha(color),
) : ColorAlpha by alphas