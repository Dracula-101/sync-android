package com.application.sync.ui.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.application.sync.ui.design.colors.SyncColorScheme
import com.application.sync.ui.design.theme.SyncTheme

@Composable
fun SyncTextButton(
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    content: @Composable () -> Unit = {},
) {
    TextButton(
        onClick = onClick,
        enabled = enabled,
        colors = SyncTheme.colorScheme.textButtonColors(),
        shape = SyncTheme.shapes.button,
        contentPadding = PaddingValues(
            horizontal = SyncTheme.spacing.padding.medium,
            vertical = SyncTheme.spacing.padding.small,
        ),
        content = {
            ProvideTextStyle(
                SyncTheme.typography.bodyLarge,
                content = content
            )
        }
    )
}

@Composable
fun SyncColorScheme.textButtonColors(
    disabledAlpha: Float = 0.5f,
): ButtonColors {
    return ButtonDefaults.textButtonColors(
        contentColor = primary.color,
        containerColor = background.color,
        disabledContentColor = primary.onContainerColor.copy(alpha = disabledAlpha),
        disabledContainerColor = background.onColor.copy(alpha = disabledAlpha),
    )
}