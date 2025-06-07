package com.android.sync.core.design.colors

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class SyncColorScheme(
    val text: TextColors,
    val background: BackgroundColors,
    val stroke: StrokeColors,
    val outlinedButton: OutlinedButtonColors,
    val filledButton: FilledButtonColors,
    val toggleButton: ToggleButtonColors,
    val chip: ChipColors,
    val input: InputColors,
    val icon: IconColors,
    val snackbar: SnackbarColors,
    val dialog: DialogColors,
    val status: StatusColors,
) {

    @Immutable
    data class TextColors(
        val primary: Color,
        val secondary: Color,
        val disabled: Color,
    )

    @Immutable
    data class BackgroundColors(
        val primary: Color,
        val secondary: Color,
        val tertiary: Color,
        val surface: Color,
        val error: Color,
    )

    @Immutable
    data class StrokeColors(
        val primary: Color,
        val secondary: Color,
        val tertiary: Color,
        val error: Color,
    )

    @Immutable
    data class OutlinedButtonColors(
        val border: Color,
        val disabledBorder: Color,
        val background: Color,
        val disabledBackground: Color,
        val content: Color,
        val disabledContent: Color,
    )

    @Immutable
    data class FilledButtonColors(
        val background: Color,
        val disabledBackground: Color,
        val content: Color,
        val disabledContent: Color,
    )

    @Immutable
    data class ToggleButtonColors(
        val selectedBackground: Color,
        val selectedContent: Color,
        val unselectedBackground: Color,
        val unselectedContent: Color,
        val disabledBackground: Color,
        val disabledContent: Color,
    )

    @Immutable
    data class ChipColors(
        val background: Color,
        val content: Color,
        val disabledBackground: Color,
        val disabledContent: Color,
    )

    @Immutable
    data class InputColors(
        val background: Color,
        val content: Color,
        val placeholder: Color,
        val error: Color,
    )

    @Immutable
    data class IconColors(
        val primary: Color,
        val secondary: Color,
        val disabled: Color,
    )

    @Immutable
    data class SnackbarColors(
        val background: Color,
        val content: Color,
        val action: Color,
        val actionDisabled: Color,
    )

    @Immutable
    data class DialogColors(
        val background: Color,
        val content: Color,
        val title: Color,
    )

    @Immutable
    data class StatusColors(
        val success: Color,
        val warning: Color,
        val error: Color,
        val info: Color,
    )
}
