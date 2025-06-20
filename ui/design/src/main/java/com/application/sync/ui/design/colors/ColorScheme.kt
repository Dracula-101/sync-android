package com.application.sync.ui.design.colors

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

/**
 * The default [SyncColorScheme] for dark mode.
 */
internal val darkSyncColorScheme: SyncColorScheme = SyncColorScheme(
    primary = MainColors(
        color = primaryDark,
        onColor = onPrimaryDark,
        containerColor = primaryContainerDark,
        onContainerColor = onPrimaryContainerDark
    ),
    secondary = MainColors(
        color = secondaryDark,
        onColor = onSecondaryDark,
        containerColor = secondaryContainerDark,
        onContainerColor = onSecondaryContainerDark
    ),
    tertiary = MainColors(
        color = tertiaryDark,
        onColor = onTertiaryDark,
        containerColor = tertiaryContainerDark,
        onContainerColor = onTertiaryContainerDark
    ),
    error = MainColors(
        color = errorDark,
        onColor = onErrorDark,
        containerColor = errorContainerDark,
        onContainerColor = onErrorContainerDark
    ),
    success = SimpleColors(
        color = successDark,
        onColor = onSuccessDark
    ),
    surface = SimpleColors(
        color = surfaceDark,
        onColor = onSurfaceDark
    ),
    background = SimpleColors(
        color = backgroundDark,
        onColor = onBackgroundDark
    ),
    surfaceVariant = SimpleColors(
        color = surfaceVariantDark,
        onColor = onSurfaceVariantDark
    ),
    inverse = InverseColors(
        primary = inversePrimaryDark,
        onPrimary = inverseOnPrimaryDark,
        surface = inverseSurfaceDark,
        onSurface = inverseOnSurfaceDark
    ),
    outline = SingleColor(color = outlineDark),
    outlineVariant = SingleColor(color = outlineVariantDark),
    shadow = SingleColor(color = shadowDark),
    scrim = SingleColor(color = scrimDark),
    surfaceTint = SingleColor(color = surfaceTintDark)
)

/**
 * The default [SyncColorScheme] for light mode.
 */
internal val lightSyncColorScheme: SyncColorScheme = SyncColorScheme(
    primary = MainColors(
        color = primaryLight,
        onColor = onPrimaryLight,
        containerColor = primaryContainerLight,
        onContainerColor = onPrimaryContainerLight
    ),
    secondary = MainColors(
        color = secondaryLight,
        onColor = onSecondaryLight,
        containerColor = secondaryContainerLight,
        onContainerColor = onSecondaryContainerLight
    ),
    tertiary = MainColors(
        color = tertiaryLight,
        onColor = onTertiaryLight,
        containerColor = tertiaryContainerLight,
        onContainerColor = onTertiaryContainerLight
    ),
    error = MainColors(
        color = errorLight,
        onColor = onErrorLight,
        containerColor = errorContainerLight,
        onContainerColor = onErrorContainerLight
    ),
    success = SimpleColors(
        color = successLight,
        onColor = onSuccessLight
    ),
    surface = SimpleColors(
        color = surfaceLight,
        onColor = onSurfaceLight
    ),
    background = SimpleColors(
        color = backgroundLight,
        onColor = onBackgroundLight
    ),
    surfaceVariant = SimpleColors(
        color = surfaceVariantLight,
        onColor = onSurfaceVariantLight
    ),
    inverse = InverseColors(
        primary = inversePrimaryLight,
        onPrimary = inverseOnPrimaryLight,
        surface = inverseSurfaceLight,
        onSurface = inverseOnSurfaceLight
    ),
    outline = SingleColor(color = outlineLight),
    outlineVariant = SingleColor(color = outlineVariantLight),
    shadow = SingleColor(color = shadowLight),
    scrim = SingleColor(color = scrimLight),
    surfaceTint = SingleColor(color = surfaceTintLight)
)

internal fun SyncColorScheme.toMaterialColorScheme(
    isDarkTheme: Boolean = false,
): ColorScheme {
    val materialTheme = if (!isDarkTheme) {
        lightColorScheme()
    } else {
        darkColorScheme()
    }
    return materialTheme.copy(
        primary = primary.color,
        onPrimary = primary.onColor,
        primaryContainer = primary.containerColor,
        onPrimaryContainer = primary.onContainerColor,
        secondary = secondary.color,
        onSecondary = secondary.onColor,
        secondaryContainer = secondary.containerColor,
        onSecondaryContainer = secondary.onContainerColor,
        tertiary = tertiary.color,
        onTertiary = tertiary.onColor,
        tertiaryContainer = tertiary.containerColor,
        onTertiaryContainer = tertiary.onContainerColor,
        error = error.color,
        onError = error.onColor,
        errorContainer = error.containerColor,
        onErrorContainer = error.onContainerColor,
        background = background.color,
        onBackground = background.onColor,
        surface = surface.color,
        onSurface = surface.onColor,
        surfaceVariant = surfaceVariant.color,
        onSurfaceVariant = surfaceVariant.onColor,
        inversePrimary = inverse.primary,
        inverseSurface = inverse.surface,
        inverseOnSurface = inverse.onSurface,
        outline = outline.color,
        outlineVariant = outlineVariant.color,
        scrim = scrim.color,
        surfaceTint = surfaceTint.color,
    )
}
