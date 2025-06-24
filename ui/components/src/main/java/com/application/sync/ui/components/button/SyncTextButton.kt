package com.application.sync.ui.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
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