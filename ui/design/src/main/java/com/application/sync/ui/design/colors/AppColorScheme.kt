package com.application.sync.ui.design.colors

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color

/**
 * Social Media Platform Color Schemes
 *
 * Light Theme: Uses a vibrant blue (#1DA1F2) similar to Twitter/X for high engagement
 * Dark Theme: Uses a softer blue (#4A9EFF) that's easier on the eyes in dark mode
 */

internal val LightColorScheme = SyncColorScheme(
    primary = PrimaryColors(
        color = Color(0xFF1DA1F2), // Vibrant social media blue
        onColor = Color(0xFFFFFFFF), // White text on blue
        container = Color(0xFFE3F2FD), // Light blue container
        onContainer = Color(0xFF0D47A1), // Dark blue text on light container
        bright = Color(0xFF42A5F5), // Brighter blue for highlights
        dim = Color(0xFF1976D2) // Dimmer blue for pressed states
    ),

    secondary = SecondaryColors(
        color = Color(0xFF7C4DFF), // Purple accent for likes, reactions
        onColor = Color(0xFFFFFFFF), // White text on purple
        container = Color(0xFFF3E5F5), // Light purple container
        onContainer = Color(0xFF4A148C) // Dark purple text
    ),

    background = BackgroundColors(
        color = Color(0xFFFFFBFE), // Pure white background
        onColor = Color(0xFF1C1B1F), // Dark text on white
        bright = Color(0xFFFFFFFF), // Bright white for elevated surfaces
        dim = Color(0xFFF5F5F5) // Light gray for subtle backgrounds
    ),

    surface = SurfaceColors(
        color = Color(0xFFFFFFFF), // White surface
        onColor = Color(0xFF1C1B1F), // Dark text on white surface
        variant = Color(0xFFF8F9FA), // Light gray surface variant
        container = Color(0xFFF1F3F4), // Light container for cards
        onContainer = Color(0xFF202124), // Dark text on light container
        highest = Color(0xFFFFFFFF), // Highest elevation (white)
        high = Color(0xFFFCFCFC), // High elevation
        low = Color(0xFFF8F9FA), // Low elevation
        lowest = Color(0xFFF5F5F5) // Lowest elevation
    ),

    error = ErrorColors(
        color = Color(0xFFE53935), // Red for errors
        onColor = Color(0xFFFFFFFF), // White text on red
        container = Color(0xFFFFEBEE), // Light red container
        onContainer = Color(0xFFB71C1C) // Dark red text
    ),

    outline = OutlineColors(
        color = Color(0xFFE0E0E0), // Light gray outlines,
        variant = Color(0xFFBDBDBD) // Slightly darker gray for variant outlines
    ),

    scrim = ScrimColors(
        color = Color(0x80000000) // Semi-transparent black scrim
    ),

    inverse = InverseColors(
        primary = Color(0xFF4A9EFF), // Lighter blue for inverse
        onPrimary = Color(0xFF003366), // Dark blue text
        secondary = Color(0xFFBB86FC), // Light purple for inverse
        onSecondary = Color(0xFF3700B3), // Dark purple text
        surface = Color(0xFF121212), // Dark surface
        onSurface = Color(0xFFE0E0E0), // Light text on dark surface
        background = Color(0xFF000000), // Black background
        onBackground = Color(0xFFFFFFFF) // White text on black
    )
)

internal val DarkColorScheme = SyncColorScheme(
    primary = PrimaryColors(
        color = Color(0xFF4A9EFF), // Softer blue for dark mode
        onColor = Color(0xFF003366), // Dark blue text on light blue
        container = Color(0xFF1E3A5F), // Dark blue container
        onContainer = Color(0xFFB3D9FF), // Light blue text on dark container
        bright = Color(0xFF6BB6FF), // Brighter variant
        dim = Color(0xFF2980B9) // Dimmer variant
    ),

    secondary = SecondaryColors(
        color = Color(0xFFBB86FC), // Light purple for dark mode
        onColor = Color(0xFF3700B3), // Dark purple text
        container = Color(0xFF4A148C), // Dark purple container
        onContainer = Color(0xFFE1BEE7) // Light purple text
    ),

    background = BackgroundColors(
        color = Color(0xFF0F0F0F), // Very dark background
        onColor = Color(0xFFE6E1E5), // Light text on dark
        bright = Color(0xFF1C1C1C), // Slightly lighter for elevation
        dim = Color(0xFF000000) // Pure black for maximum contrast
    ),

    surface = SurfaceColors(
        color = Color(0xFF1C1C1C), // Dark surface
        onColor = Color(0xFFE6E1E5), // Light text on dark surface
        variant = Color(0xFF2C2C2C), // Darker surface variant
        container = Color(0xFF262626), // Dark container for cards
        onContainer = Color(0xFFE0E0E0), // Light text on dark container
        highest = Color(0xFF383838), // Highest elevation
        high = Color(0xFF2E2E2E), // High elevation
        low = Color(0xFF1A1A1A), // Low elevation
        lowest = Color(0xFF121212) // Lowest elevation
    ),

    error = ErrorColors(
        color = Color(0xFFFF6B6B), // Softer red for dark mode
        onColor = Color(0xFF690005), // Dark red text
        container = Color(0xFF93000A), // Dark red container
        onContainer = Color(0xFFFFDAD6) // Light red text
    ),

    outline = OutlineColors(
        color = Color(0xFF404040), // Gray outlines for dark mode
        variant = Color(0xFF606060) // Slightly lighter gray for variant outlines
    ),

    scrim = ScrimColors(
        color = Color(0xCC000000) // Darker scrim for dark mode
    ),

    inverse = InverseColors(
        primary = Color(0xFF1DA1F2), // Vibrant blue for inverse
        onPrimary = Color(0xFFFFFFFF), // White text
        secondary = Color(0xFF7C4DFF), // Purple for inverse
        onSecondary = Color(0xFFFFFFFF), // White text
        surface = Color(0xFFFFFFFF), // White surface
        onSurface = Color(0xFF1C1B1F), // Dark text on white surface
        background = Color(0xFFFFFBFE), // Light background
        onBackground = Color(0xFF1C1B1F) // Dark text on light
    )
)

/**
 * Converts a SyncColorScheme to a Material ColorScheme.
 *
 * This function maps the custom SyncColorScheme to the Material3 ColorScheme
 * format, ensuring compatibility with Material Design components.
 *
 * @return A ColorScheme object compatible with Material Design.
 */
fun SyncColorScheme.toMaterialColorScheme() = ColorScheme(
    // Primary colors
    primary = primary.color,
    onPrimary = primary.onColor,
    primaryContainer = primary.container,
    onPrimaryContainer = primary.onContainer,

    // Secondary colors
    secondary = secondary.color,
    onSecondary = secondary.onColor,
    secondaryContainer = secondary.container,
    onSecondaryContainer = secondary.onContainer,

    // Tertiary colors (using secondary as fallback since not defined in SyncColorScheme)
    tertiary = secondary.color,
    onTertiary = secondary.onColor,
    tertiaryContainer = secondary.container,
    onTertiaryContainer = secondary.onContainer,

    // Background colors
    background = background.color,
    onBackground = background.onColor,

    // Surface colors
    surface = surface.color,
    onSurface = surface.onColor,
    surfaceVariant = surface.variant,
    onSurfaceVariant = surface.onContainer,
    surfaceTint = primary.color,

    // Surface containers (Material 3 additions)
    surfaceContainer = surface.container,
    surfaceContainerHigh = surface.high,
    surfaceContainerHighest = surface.highest,
    surfaceContainerLow = surface.low,
    surfaceContainerLowest = surface.lowest,

    // Surface brightness variants
    surfaceBright = background.bright,
    surfaceDim = background.dim,

    // Error colors
    error = error.color,
    onError = error.onColor,
    errorContainer = error.container,
    onErrorContainer = error.onContainer,

    // Outline colors
    outline = outline.color,
    outlineVariant = outline.variant, // Standard Material 3 outline variant

    // Scrim
    scrim = scrim.color,

    // Inverse colors
    inversePrimary = inverse.primary,
    inverseSurface = inverse.surface,
    inverseOnSurface = inverse.onSurface
)
