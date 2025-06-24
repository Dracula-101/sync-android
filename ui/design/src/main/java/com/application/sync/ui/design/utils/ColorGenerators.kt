package com.application.sync.ui.design.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.ColorUtils
import com.application.sync.ui.design.colors.ColorAlpha
import com.application.sync.ui.design.colors.ColorShades

/**
 * Utility object for generating color shades and alpha variants.
 * Contains helper functions to compute colors once and store them.
 */
object ColorGenerators {

    /**
     * Generates all shades for a given base color.
     *
     * @param baseColor The base color to generate shades from
     * @return A data class containing all pre-computed shades
     */
    fun generateShades(baseColor: Color): ColorShadesData {
        val argb = baseColor.toArgb()
        return ColorShadesData(
            shade50 = generateShade(argb, 0.95f),
            shade100 = generateShade(argb, 0.9f),
            shade200 = generateShade(argb, 0.8f),
            shade300 = generateShade(argb, 0.7f),
            shade400 = generateShade(argb, 0.6f),
            shade500 = baseColor,
            shade600 = generateShade(argb, 0.5f),
            shade700 = generateShade(argb, 0.4f),
            shade800 = generateShade(argb, 0.3f),
            shade900 = generateShade(argb, 0.2f),
            shade950 = generateShade(argb, 0.1f)
        )
    }

    /**
     * Generates all alpha variants for a given base color.
     *
     * @param baseColor The base color to generate alpha variants from
     * @return A data class containing all pre-computed alpha variants
     */
    fun generateAlpha(baseColor: Color): ColorAlphaData {
        return ColorAlphaData(
            alpha50 = baseColor.copy(alpha = 0.05f),
            alpha100 = baseColor.copy(alpha = 0.10f),
            alpha200 = baseColor.copy(alpha = 0.20f),
            alpha300 = baseColor.copy(alpha = 0.30f),
            alpha400 = baseColor.copy(alpha = 0.40f),
            alpha500 = baseColor.copy(alpha = 0.50f),
            alpha600 = baseColor.copy(alpha = 0.60f),
            alpha700 = baseColor.copy(alpha = 0.70f),
            alpha800 = baseColor.copy(alpha = 0.80f),
            alpha900 = baseColor.copy(alpha = 0.90f),
            alpha950 = baseColor.copy(alpha = 0.95f)
        )
    }

    /**
     * Generates a shade by adjusting the lightness of the color.
     *
     * @param argb The ARGB color value
     * @param lightness The target lightness (0.0 to 1.0)
     * @return The generated shade color
     */
    private fun generateShade(argb: Int, lightness: Float): Color {
        val hsl = FloatArray(3)
        ColorUtils.colorToHSL(argb, hsl)
        hsl[2] = lightness.coerceIn(0f, 1f)
        return Color(ColorUtils.HSLToColor(hsl))
    }
}

/**
 * Data class to hold pre-computed shade values.
 */
data class ColorShadesData(
    override val shade50: Color,
    override val shade100: Color,
    override val shade200: Color,
    override val shade300: Color,
    override val shade400: Color,
    override val shade500: Color,
    override val shade600: Color,
    override val shade700: Color,
    override val shade800: Color,
    override val shade900: Color,
    override val shade950: Color
) : ColorShades

/**
 * Data class to hold pre-computed alpha values.
 */
data class ColorAlphaData(
    override val alpha50: Color,
    override val alpha100: Color,
    override val alpha200: Color,
    override val alpha300: Color,
    override val alpha400: Color,
    override val alpha500: Color,
    override val alpha600: Color,
    override val alpha700: Color,
    override val alpha800: Color,
    override val alpha900: Color,
    override val alpha950: Color
) : ColorAlpha