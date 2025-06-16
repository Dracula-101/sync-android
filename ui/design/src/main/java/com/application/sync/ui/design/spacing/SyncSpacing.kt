package com.application.sync.ui.design.spacing

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp

@Immutable
data class SyncSpacing(
    // Basic spacing units
    val extraSmall: Dp,
    val small: Dp,
    val medium: Dp,
    val large: Dp,
    val extraLarge: Dp,

    // Padding variations
    val paddingTiny: Dp,
    val paddingSmall: Dp,
    val paddingMedium: Dp,
    val paddingLarge: Dp,
    val paddingExtraLarge: Dp,

    // Margin variations
    val marginTiny: Dp,
    val marginExtraSmall: Dp,
    val marginSmall: Dp,
    val marginMedium: Dp,
    val marginLarge: Dp,
    val marginExtraLarge: Dp,

    // Gap spacing (for layouts)
    val gapTiny: Dp,
    val gapSmall: Dp,
    val gapMedium: Dp,
    val gapLarge: Dp,
    val gapExtraLarge: Dp,

    // Border radius
    val radiusSmall: Dp,
    val radiusMedium: Dp,
    val radiusLarge: Dp,
    val radiusExtraLarge: Dp,
    val radiusCircular: Dp,

    // Elevation levels
    val elevationNone: Dp,
    val elevationLow: Dp,
    val elevationMedium: Dp,
    val elevationHigh: Dp,
    val elevationExtraHigh: Dp,

    // Component heights
    val heightTiny: Dp,
    val heightSmall: Dp,
    val heightMedium: Dp,
    val heightLarge: Dp,
    val heightExtraLarge: Dp,

    // Component widths
    val widthTiny: Dp,
    val widthSmall: Dp,
    val widthMedium: Dp,
    val widthLarge: Dp,
    val widthExtraLarge: Dp,

    // Icon sizes
    val iconTiny: Dp,
    val iconSmall: Dp,
    val iconMedium: Dp,
    val iconLarge: Dp,
    val iconExtraLarge: Dp,

    // Divider thickness
    val dividerThin: Dp,
    val dividerMedium: Dp,
    val dividerThick: Dp,
)