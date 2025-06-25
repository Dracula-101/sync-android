package com.application.sync.ui.components.dialog

import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.application.sync.ui.design.colors.SyncColorScheme

/**
 * Dialog colors data class for theming dialog components
 */
data class DialogColors(
    val background: Color,
    val title: Color,
    val content: Color,
    val border: Color,
)

/**
 * Extension function to get dialog colors from SyncColorScheme
 */
@Composable
internal fun SyncColorScheme.dialogColors(): DialogColors {
    return DialogColors(
        background = surface.container,
        title = surface.onContainer,
        content = surface.onContainer,
        border = outline.color
    )
}

/**
 * Extension function to get Card colors for dialogs
 */
@Composable
internal fun SyncColorScheme.dialogCardColors(): CardColors {
    return CardDefaults.cardColors()
}