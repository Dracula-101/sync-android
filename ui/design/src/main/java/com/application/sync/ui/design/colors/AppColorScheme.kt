package com.application.sync.ui.design.colors

import androidx.compose.ui.graphics.Color

/**
 * Light theme color scheme for Sync app
 *
 * Provides a clean, professional light theme with blue primary (#4C68D5)
 * and orange secondary (#FF6B35) colors. Background is slightly darker
 * than surface to create proper elevation hierarchy.
 *
 * @return SyncColorScheme configured for light theme
 */
fun lightTheme(): SyncColorScheme {
    return SyncColorScheme(
        /**
         * Primary colors for Sync app branding
         * Blue-purple (#4C68D5) with proper contrast ratios
         */
        /**
         * Primary colors optimized for dark theme
         * Brighter blue (#6B7FE3) for better visibility on dark backgrounds
         */
        primary = PrimaryColors(
            color = Color(0xFF4C68D5),
            onColor = Color(0xFFFFFFFF),
            container = Color(0xFFE1E7FF),
            onContainer = Color(0xFF001946),
            bright = Color(0xFF6B7FE3),
            dim = Color(0xFF3E56B8)
        ),
        /**
         * Secondary colors for accents and CTAs
         * Warm orange (#FF6B35) that complements primary
         */
        /**
         * Secondary colors optimized for dark theme
         * Adjusted orange (#FF7A45) with dark container shade
         */
        secondary = SecondaryColors(
            color = Color(0xFFFF6B35),
            onColor = Color(0xFFFFFFFF),
            container = Color(0xFFFFE8E0),
            onContainer = Color(0xFF2D1400)
        ),
        /**
         * Background colors for main app backdrop
         * Slightly darker than surface for proper elevation
         */
        /**
         * Background colors for dark theme
         * True black (#000000) for OLED optimization
         */
        background = BackgroundColors(
            color = Color(0xFFFAFAFA),
            onColor = Color(0xFF1A1A1A),
            bright = Color(0xFFFFFFFF),
            dim = Color(0xFFF5F5F5)
        ),
        /**
         * Surface colors for cards, sheets, and elevated components
         * Lighter than background with proper hierarchy levels
         */
        /**
         * Surface colors for dark theme elevation
         * Progressive lightness for proper depth hierarchy
         */
        surface = SurfaceColors(
            color = Color(0xFFFFFFFF),
            onColor = Color(0xFF1A1A1A),
            variant = Color(0xFFF8F8F8),
            container = Color(0xFFFCFCFC),
            onContainer = Color(0xFF1A1A1A),
            highest = Color(0xFFFFFFFF),
            high = Color(0xFFFEFEFE),
            low = Color(0xFFF8F8F8),
            lowest = Color(0xFFF0F0F0)
        ),
        /**
         * Error colors for alerts and validation states
         * Red color family with proper contrast
         */
        /**
         * Error colors for dark theme
         * Brighter red (#EF4444) for visibility on dark backgrounds
         */
        error = ErrorColors(
            color = Color(0xFFDC2626),
            onColor = Color(0xFFFFFFFF),
            container = Color(0xFFFEE2E2),
            onContainer = Color(0xFF991B1B)
        ),
        /**
         * Outline colors for borders and dividers
         * Subtle gray tones for clean separation
         */
        /**
         * Outline colors for dark theme borders
         * Darker gray tones for subtle separation
         */
        outline = OutlineColors(
            color = Color(0xFFD1D5DB),
            variant = Color(0xFFE5E7EB)
        ),
        /**
         * Stroke colors for icons and graphics
         * More prominent than outline for visual emphasis
         */
        scrim = ScrimColors(
            color = Color(0xFF9CA3AF),
            variant = Color(0xFFD1D5DB)
        ),
        /**
         * Inverse colors for tooltips and contrasting elements
         * Dark theme colors used in light theme context
         */
        /**
         * Inverse colors for dark theme contrasting elements
         * Light theme colors used in dark theme context
         */
        inverse = InverseColors(
            primary = Color(0xFF6B7FE3),
            onPrimary = Color(0xFF000000),
            secondary = Color(0xFFFF8A55),
            onSecondary = Color(0xFF000000),
            surface = Color(0xFF1A1F2E),
            onSurface = Color(0xFFFFFFFF),
            background = Color(0xFF000000),
            onBackground = Color(0xFFFFFFFF)
        ),
        shades = lightThemeShades()
    )
}

/**
 * Dark theme color scheme for Sync app
 *
 * Provides a sophisticated dark theme with adjusted blue primary (#6B7FE3)
 * and orange secondary (#FF7A45) colors optimized for dark backgrounds.
 * Uses true black background with proper surface elevation.
 *
 * @return SyncColorScheme configured for dark theme
 */
fun darkTheme(): SyncColorScheme {
    return SyncColorScheme(
        primary = PrimaryColors(
            color = Color(0xFF6B7FE3),
            onColor = Color(0xFFFFFFFF),
            container = Color(0xFF2A3B7A),
            onContainer = Color(0xFFE1E7FF),
            bright = Color(0xFF8A9AEF),
            dim = Color(0xFF5A6ED1)
        ),
        secondary = SecondaryColors(
            color = Color(0xFFFF7A45),
            onColor = Color(0xFFFFFFFF),
            container = Color(0xFF4A2415),
            onContainer = Color(0xFFFFD4C4)
        ),
        background = BackgroundColors(
            color = Color(0xFF000000),
            onColor = Color(0xFFFFFFFF),
            bright = Color(0xFF1A1A1A),
            dim = Color(0xFF0A0A0A)
        ),
        surface = SurfaceColors(
            color = Color(0xFF0F0F0F),
            onColor = Color(0xFFFFFFFF),
            variant = Color(0xFF1A1A1A),
            container = Color(0xFF151515),
            onContainer = Color(0xFFFFFFFF),
            highest = Color(0xFF2A2A2A),
            high = Color(0xFF1F1F1F),
            low = Color(0xFF0A0A0A),
            lowest = Color(0xFF000000)
        ),
        error = ErrorColors(
            color = Color(0xFFEF4444),
            onColor = Color(0xFFFFFFFF),
            container = Color(0xFF991B1B),
            onContainer = Color(0xFFFEE2E2)
        ),
        outline = OutlineColors(
            color = Color(0xFF374151),
            variant = Color(0xFF4B5563)
        ),
        /**
         * Stroke colors for dark theme icons and graphics
         * Balanced gray for visual emphasis without harshness
         */
        scrim = ScrimColors(
            color = Color(0xFF6B7280),
            variant = Color(0xFF4B5563)
        ),
        inverse = InverseColors(
            primary = Color(0xFF4C68D5),
            onPrimary = Color(0xFFFFFFFF),
            secondary = Color(0xFFFF6B35),
            onSecondary = Color(0xFFFFFFFF),
            surface = Color(0xFFFFFFFF),
            onSurface = Color(0xFF1A1A1A),
            background = Color(0xFFFAFAFA),
            onBackground = Color(0xFF1A1A1A)
        ),
        shades = darkThemeShades()
    )
}

/**
 * Light theme color shades data for Sync app
 *
 * Provides complete shade ranges (50-900) for primary, secondary, and background colors.
 * Each shade offers different intensities for flexible UI design and proper hierarchy.
 *
 * @return ColorShadesData configured for light theme
 */
fun lightThemeShades(): ColorShadesData {
    return ColorShadesData(
        /**
         * Primary color shades - Blue-purple family (#4C68D5)
         * From lightest tint (50) to darkest shade (900)
         */
        primary = Shades(
            shade50 = Color(0xFFF4F6FF),
            shade100 = Color(0xFFE8EDFF),
            shade200 = Color(0xFFD1DBFF),
            shade300 = Color(0xFFA3B9FF),
            shade400 = Color(0xFF7590EA),
            shade500 = Color(0xFF4C68D5), // Original primary
            shade600 = Color(0xFF3E56B8),
            shade700 = Color(0xFF32459A),
            shade800 = Color(0xFF2A3B7A),
            shade900 = Color(0xFF1E2B5A)
        ),

        /**
         * Secondary color shades - Orange family (#FF6B35)
         * Warm complement to primary blue for accents and CTAs
         */
        secondary = Shades(
            shade50 = Color(0xFFFFF7F3),
            shade100 = Color(0xFFFFEDE6),
            shade200 = Color(0xFFFFD9CC),
            shade300 = Color(0xFFFFB899),
            shade400 = Color(0xFFFF9266),
            shade500 = Color(0xFFFF6B35), // Original secondary
            shade600 = Color(0xFFE55A2B),
            shade700 = Color(0xFFCC4A21),
            shade800 = Color(0xFFB33A18),
            shade900 = Color(0xFF992A0F)
        ),

        /**
         * Background color shades - Neutral gray family (#FAFAFA)
         * Subtle variations for layering and depth
         */
        background = Shades(
            shade50 = Color(0xFFFFFFFF),
            shade100 = Color(0xFFFEFEFE),
            shade200 = Color(0xFFFCFCFC),
            shade300 = Color(0xFFFAFAFA), // Original background
            shade400 = Color(0xFFF5F5F5),
            shade500 = Color(0xFFF0F0F0),
            shade600 = Color(0xFFE8E8E8),
            shade700 = Color(0xFFE0E0E0),
            shade800 = Color(0xFFD5D5D5),
            shade900 = Color(0xFFC0C0C0)
        )
    )
}

/**
 * Dark theme color shades data for Sync app
 *
 * Provides complete shade ranges optimized for dark backgrounds.
 * Colors are adjusted for better visibility and contrast in dark mode.
 *
 * @return ColorShadesData configured for dark theme
 */
fun darkThemeShades(): ColorShadesData {
    return ColorShadesData(
        /**
         * Primary color shades for dark theme - Brighter blue-purple family
         * Optimized for visibility on dark backgrounds
         */
        primary = Shades(
            shade50 = Color(0xFFF4F6FF),
            shade100 = Color(0xFFE8EDFF),
            shade200 = Color(0xFFD1DBFF),
            shade300 = Color(0xFFA3B9FF),
            shade400 = Color(0xFF8A9AEF),
            shade500 = Color(0xFF6B7FE3), // Dark theme primary
            shade600 = Color(0xFF5A6ED1),
            shade700 = Color(0xFF4C68D5), // Original primary
            shade800 = Color(0xFF3E56B8),
            shade900 = Color(0xFF2A3B7A)
        ),

        /**
         * Secondary color shades for dark theme - Adjusted orange family
         * Balanced warmth for dark mode interfaces
         */
        secondary = Shades(
            shade50 = Color(0xFFFFF7F3),
            shade100 = Color(0xFFFFEDE6),
            shade200 = Color(0xFFFFD9CC),
            shade300 = Color(0xFFFFB899),
            shade400 = Color(0xFFFFA575),
            shade500 = Color(0xFFFF7A45), // Dark theme secondary
            shade600 = Color(0xFFE5724A),
            shade700 = Color(0xFFFF6B35), // Original secondary
            shade800 = Color(0xFFE55A2B),
            shade900 = Color(0xFFCC4A21)
        ),

        /**
         * Background color shades for dark theme - True black to gray
         * Progressive lightness for proper elevation hierarchy
         */
        background = Shades(
            shade50 = Color(0xFF404040),
            shade100 = Color(0xFF353535),
            shade200 = Color(0xFF2A2A2A),
            shade300 = Color(0xFF1F1F1F),
            shade400 = Color(0xFF151515),
            shade500 = Color(0xFF0A0A0A),
            shade600 = Color(0xFF050505),
            shade700 = Color(0xFF030303),
            shade800 = Color(0xFF010101),
            shade900 = Color(0xFF000000) // Original dark background
        )
    )
}