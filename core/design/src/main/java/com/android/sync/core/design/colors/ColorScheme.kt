package com.android.sync.core.design.colors

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color

/**
 * The default [SyncColorScheme] for dark mode.
 */
internal val darkSyncColorScheme: SyncColorScheme = SyncColorScheme(
    text = SyncColorScheme.TextColors(
        primary = PrimitiveColors.slate100,
        secondary = PrimitiveColors.slate400,
        disabled = PrimitiveColors.slate600,
    ),
    background = SyncColorScheme.BackgroundColors(
        primary = PrimitiveColors.slate950,
        secondary = PrimitiveColors.slate900,
        tertiary = PrimitiveColors.slate800,
        surface = PrimitiveColors.slate850,
        error = PrimitiveColors.red950,
    ),
    stroke = SyncColorScheme.StrokeColors(
        primary = PrimitiveColors.slate700,
        secondary = PrimitiveColors.slate600,
        tertiary = PrimitiveColors.primary500,
        error = PrimitiveColors.red500,
    ),
    outlinedButton = SyncColorScheme.OutlinedButtonColors(
        border = PrimitiveColors.primary500,
        disabledBorder = PrimitiveColors.slate800,
        background = PrimitiveColors.primary1000,
        disabledBackground = PrimitiveColors.slate900,
        content = PrimitiveColors.primary500,
        disabledContent = PrimitiveColors.slate700,
    ),
    filledButton = SyncColorScheme.FilledButtonColors(
        background = PrimitiveColors.primary500,
        disabledBackground = PrimitiveColors.slate800,
        content = PrimitiveColors.slate50,
        disabledContent = PrimitiveColors.slate700,
    ),
    toggleButton = SyncColorScheme.ToggleButtonColors(
        selectedBackground = PrimitiveColors.primary500,
        selectedContent = PrimitiveColors.slate50,
        unselectedBackground = PrimitiveColors.slate800,
        unselectedContent = PrimitiveColors.slate300,
        disabledBackground = PrimitiveColors.slate700,
        disabledContent = PrimitiveColors.slate500,
    ),
    chip = SyncColorScheme.ChipColors(
        background = PrimitiveColors.slate800,
        content = PrimitiveColors.slate200,
        disabledBackground = PrimitiveColors.slate700,
        disabledContent = PrimitiveColors.slate500,
    ),
    input = SyncColorScheme.InputColors(
        background = PrimitiveColors.slate850,
        content = PrimitiveColors.slate100,
        placeholder = PrimitiveColors.slate400,
        error = PrimitiveColors.red400,
    ),
    icon = SyncColorScheme.IconColors(
        primary = PrimitiveColors.slate300,
        secondary = PrimitiveColors.primary400,
        disabled = PrimitiveColors.slate600,
    ),
    snackbar = SyncColorScheme.SnackbarColors(
        background = PrimitiveColors.slate800,
        content = PrimitiveColors.slate100,
        action = PrimitiveColors.primary400,
        actionDisabled = PrimitiveColors.slate500,
    ),
    dialog = SyncColorScheme.DialogColors(
        background = PrimitiveColors.slate900,
        content = PrimitiveColors.slate200,
        title = PrimitiveColors.slate50,
    ),
    status = SyncColorScheme.StatusColors(
        success = PrimitiveColors.green400,
        warning = PrimitiveColors.yellow400,
        error = PrimitiveColors.red400,
        info = PrimitiveColors.blue400,
    ),
)

/**
 * The default [SyncColorScheme] for light mode.
 */
internal val lightSyncColorScheme: SyncColorScheme = SyncColorScheme(
    text = SyncColorScheme.TextColors(
        primary = PrimitiveColors.slate900,
        secondary = PrimitiveColors.slate700,
        disabled = PrimitiveColors.slate500,
    ),
    background = SyncColorScheme.BackgroundColors(
        primary = PrimitiveColors.slate50,
        secondary = PrimitiveColors.white,
        tertiary = PrimitiveColors.slate100,
        surface = PrimitiveColors.white,
        error = PrimitiveColors.red50,
    ),
    stroke = SyncColorScheme.StrokeColors(
        primary = PrimitiveColors.slate200,
        secondary = PrimitiveColors.slate300,
        tertiary = PrimitiveColors.primary500,
        error = PrimitiveColors.red500,
    ),
    outlinedButton = SyncColorScheme.OutlinedButtonColors(
        border = PrimitiveColors.primary500,
        disabledBorder = PrimitiveColors.slate300,
        background = PrimitiveColors.primary100,
        disabledBackground = PrimitiveColors.slate200,
        content = PrimitiveColors.primary500,
        disabledContent = PrimitiveColors.slate400,
    ),
    filledButton = SyncColorScheme.FilledButtonColors(
        background = PrimitiveColors.primary500,
        disabledBackground = PrimitiveColors.slate200,
        content = PrimitiveColors.white,
        disabledContent = PrimitiveColors.slate400,
    ),
    toggleButton = SyncColorScheme.ToggleButtonColors(
        selectedBackground = PrimitiveColors.primary500,
        selectedContent = PrimitiveColors.white,
        unselectedBackground = PrimitiveColors.slate100,
        unselectedContent = PrimitiveColors.slate700,
        disabledBackground = PrimitiveColors.slate200,
        disabledContent = PrimitiveColors.slate400,
    ),
    chip = SyncColorScheme.ChipColors(
        background = PrimitiveColors.slate100,
        content = PrimitiveColors.slate800,
        disabledBackground = PrimitiveColors.slate200,
        disabledContent = PrimitiveColors.slate400,
    ),
    input = SyncColorScheme.InputColors(
        background = PrimitiveColors.white,
        content = PrimitiveColors.slate900,
        placeholder = PrimitiveColors.slate500,
        error = PrimitiveColors.red600,
    ),
    icon = SyncColorScheme.IconColors(
        primary = PrimitiveColors.slate600,
        secondary = PrimitiveColors.primary500,
        disabled = PrimitiveColors.slate300,
    ),
    snackbar = SyncColorScheme.SnackbarColors(
        background = PrimitiveColors.slate900,
        content = PrimitiveColors.white,
        action = PrimitiveColors.primary400,
        actionDisabled = PrimitiveColors.slate400,
    ),
    dialog = SyncColorScheme.DialogColors(
        background = PrimitiveColors.white,
        content = PrimitiveColors.slate700,
        title = PrimitiveColors.slate900,
    ),
    status = SyncColorScheme.StatusColors(
        success = PrimitiveColors.green600,
        warning = PrimitiveColors.yellow600,
        error = PrimitiveColors.red600,
        info = PrimitiveColors.blue600,
    ),
)

/**
 * Creates a [SyncColorScheme] based on dynamic Material You colors.
 */
@Suppress("LongMethod")
internal fun dynamicSyncColorScheme(
    materialColorScheme: ColorScheme,
    isDarkTheme: Boolean,
): SyncColorScheme {
    val defaultTheme = if (isDarkTheme) darkSyncColorScheme else lightSyncColorScheme
    return SyncColorScheme(
        text = SyncColorScheme.TextColors(
            primary = materialColorScheme.onBackground,
            secondary = materialColorScheme.onSurface,
            disabled = materialColorScheme.onSurface.copy(alpha = 0.38f),
        ),
        background = SyncColorScheme.BackgroundColors(
            primary = materialColorScheme.background,
            secondary = materialColorScheme.surface,
            tertiary = materialColorScheme.surfaceContainer,
            surface = materialColorScheme.surface,
            error = materialColorScheme.errorContainer,
        ),
        stroke = SyncColorScheme.StrokeColors(
            primary = materialColorScheme.outline,
            secondary = materialColorScheme.outlineVariant,
            tertiary = materialColorScheme.primary,
            error = materialColorScheme.error,
        ),
        outlinedButton = SyncColorScheme.OutlinedButtonColors(
            border = materialColorScheme.primary,
            disabledBorder = materialColorScheme.outline,
            background = Color.Transparent,
            disabledBackground = Color.Transparent,
            content = materialColorScheme.primary,
            disabledContent = materialColorScheme.onSurface.copy(alpha = 0.38f),
        ),
        filledButton = SyncColorScheme.FilledButtonColors(
            background = materialColorScheme.primary,
            disabledBackground = materialColorScheme.onSurface.copy(alpha = 0.12f),
            content = materialColorScheme.onPrimary,
            disabledContent = materialColorScheme.onSurface.copy(alpha = 0.38f),
        ),
        toggleButton = SyncColorScheme.ToggleButtonColors(
            selectedBackground = materialColorScheme.primary,
            selectedContent = materialColorScheme.onPrimary,
            unselectedBackground = materialColorScheme.surfaceContainer,
            unselectedContent = materialColorScheme.onSurface,
            disabledBackground = materialColorScheme.onSurface.copy(alpha = 0.12f),
            disabledContent = materialColorScheme.onSurface.copy(alpha = 0.38f),
        ),
        chip = SyncColorScheme.ChipColors(
            background = materialColorScheme.surfaceContainer,
            content = materialColorScheme.onSurface,
            disabledBackground = materialColorScheme.onSurface.copy(alpha = 0.12f),
            disabledContent = materialColorScheme.onSurface.copy(alpha = 0.38f),
        ),
        input = SyncColorScheme.InputColors(
            background = materialColorScheme.surface,
            content = materialColorScheme.onSurface,
            placeholder = materialColorScheme.onSurface.copy(alpha = 0.6f),
            error = materialColorScheme.error,
        ),
        icon = SyncColorScheme.IconColors(
            primary = materialColorScheme.onSurface,
            secondary = materialColorScheme.primary,
            disabled = materialColorScheme.onSurface.copy(alpha = 0.38f),
        ),
        snackbar = SyncColorScheme.SnackbarColors(
            background = materialColorScheme.inverseSurface,
            content = materialColorScheme.inverseOnSurface,
            action = materialColorScheme.inversePrimary,
            actionDisabled = materialColorScheme.inverseOnSurface.copy(alpha = 0.38f),
        ),
        dialog = SyncColorScheme.DialogColors(
            background = materialColorScheme.surface,
            content = materialColorScheme.onSurface,
            title = materialColorScheme.onSurface,
        ),
        status = SyncColorScheme.StatusColors(
            success = defaultTheme.status.success,
            warning = defaultTheme.status.warning,
            error = materialColorScheme.error,
            info = defaultTheme.status.info,
        ),
    )
}

/**
 * Derives a Material [ColorScheme] from the [SyncColorScheme] using the [defaultColorScheme]
 * as a baseline.
 */
internal fun SyncColorScheme.toMaterialColorScheme(
    defaultColorScheme: ColorScheme,
): ColorScheme = defaultColorScheme.copy(
    primary = this.stroke.primary,
    onSurfaceVariant = this.text.secondary,
)

/**
 * The raw colors that support the [SyncColorScheme], designed for social media platform.
 */
private data object PrimitiveColors {
    // Primary brand colors (based on #3565e3)
    val primary50: Color = Color(color = 0xFFF0F4FF)
    val primary100: Color = Color(color = 0xFFE0E8FF)
    val primary200: Color = Color(color = 0xFFC7D2FE)
    val primary300: Color = Color(color = 0xFFA5B4FC)
    val primary400: Color = Color(color = 0xFF818CF8)
    val primary500: Color = Color(color = 0xFF3565E3) // Primary color
    val primary600: Color = Color(color = 0xFF4F46E5)
    val primary700: Color = Color(color = 0xFF4338CA)
    val primary800: Color = Color(color = 0xFF3730A3)
    val primary900: Color = Color(color = 0xFF312E81)
    val primary950: Color = Color(color = 0xFF1E1B4B)
    val primary1000: Color = Color(color = 0xFF0F0C2A)

    val white: Color = Color(color = 0xFFFFFFFF)
    val slate50: Color = Color(color = 0xFFF8FAFC)
    val slate100: Color = Color(color = 0xFFF1F5F9)
    val slate200: Color = Color(color = 0xFFE2E8F0)
    val slate300: Color = Color(color = 0xFFCBD5E1)
    val slate400: Color = Color(color = 0xFF94A3B8)
    val slate500: Color = Color(color = 0xFF64748B)
    val slate600: Color = Color(color = 0xFF475569)
    val slate700: Color = Color(color = 0xFF334155)
    val slate800: Color = Color(color = 0xFF1E293B)
    val slate850: Color = Color(color = 0xFF172032)
    val slate900: Color = Color(color = 0xFF0F172A)
    val slate950: Color = Color(color = 0xFF020617)

    // Status colors
    val green50: Color = Color(color = 0xFFF0FDF4)
    val green100: Color = Color(color = 0xFFDCFCE7)
    val green400: Color = Color(color = 0xFF4ADE80)
    val green500: Color = Color(color = 0xFF22C55E)
    val green600: Color = Color(color = 0xFF16A34A)

    val yellow50: Color = Color(color = 0xFFFEFCE8)
    val yellow100: Color = Color(color = 0xFFFEF3C7)
    val yellow400: Color = Color(color = 0xFFFBBF24)
    val yellow500: Color = Color(color = 0xFFF59E0B)
    val yellow600: Color = Color(color = 0xFFD97706)

    val red50: Color = Color(color = 0xFFFEF2F2)
    val red100: Color = Color(color = 0xFFFECDD3)
    val red400: Color = Color(color = 0xFFF87171)
    val red500: Color = Color(color = 0xFFEF4444)
    val red600: Color = Color(color = 0xFFDC2626)
    val red950: Color = Color(color = 0xFF450A0A)

    val blue400: Color = Color(color = 0xFF60A5FA)
    val blue500: Color = Color(color = 0xFF3B82F6)
    val blue600: Color = Color(color = 0xFF2563EB)
}
