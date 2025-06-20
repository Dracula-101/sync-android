package com.application.sync.ui.design.colors

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class SyncColorScheme(
    val primary: MainColors,
    val secondary: MainColors,
    val tertiary: MainColors,
    val error: MainColors,
    val success: SimpleColors,
    val surface: SimpleColors,
    val background: SimpleColors,
    val surfaceVariant: SimpleColors,
    val inverse: InverseColors,
    val outline: SingleColor,
    val outlineVariant: SingleColor,
    val shadow: SingleColor,
    val scrim: SingleColor,
    val surfaceTint: SingleColor,
)

@Immutable
data class MainColors(
    val color: Color,
    val onColor: Color,
    val containerColor: Color,
    val onContainerColor: Color,
)

@Immutable
data class InverseColors(
    val primary: Color,
    val onPrimary: Color,
    val surface: Color,
    val onSurface: Color,
)

@Immutable
data class SimpleColors(
    val color: Color,
    val onColor: Color,
)

@Immutable
data class SingleColor(
    val color: Color,
)

@Immutable
data class Shades(
    val color50: Color,
    val color100: Color,
    val color200: Color,
    val color300: Color,
    val color400: Color,
    val color500: Color,
    val color600: Color,
    val color700: Color,
    val color800: Color,
    val color900: Color,
)