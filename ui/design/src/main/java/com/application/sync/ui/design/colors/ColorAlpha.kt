package com.application.sync.ui.design.colors

import androidx.compose.ui.graphics.Color

/**
 * Interface for providing pre-computed alpha variants of a color.
 * All alpha values should be computed once and cached.
 */
interface ColorAlpha {
    /** 5% opacity */
    val alpha50: Color

    /** 10% opacity */
    val alpha100: Color

    /** 20% opacity */
    val alpha200: Color

    /** 30% opacity */
    val alpha300: Color

    /** 40% opacity */
    val alpha400: Color

    /** 50% opacity */
    val alpha500: Color

    /** 60% opacity */
    val alpha600: Color

    /** 70% opacity */
    val alpha700: Color

    /** 80% opacity */
    val alpha800: Color

    /** 90% opacity */
    val alpha900: Color

    /** 95% opacity */
    val alpha950: Color
}