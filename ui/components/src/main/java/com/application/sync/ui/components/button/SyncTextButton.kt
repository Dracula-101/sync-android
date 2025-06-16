package com.application.sync.ui.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonDefaults
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
        colors = ButtonDefaults.textButtonColors(
            contentColor = SyncTheme.colorScheme.stroke.primary,
            containerColor = SyncTheme.colorScheme.outlinedButton.background,
            disabledContainerColor = SyncTheme.colorScheme.background.secondary,
            disabledContentColor = SyncTheme.colorScheme.text.disabled,
        ),
        shape = SyncTheme.shapes.button,
        contentPadding = PaddingValues(
            horizontal = SyncTheme.spacing.medium,
            vertical = SyncTheme.spacing.small,
        ),
        content = {
            ProvideTextStyle(
                SyncTheme.typography.bodyLarge,
                content = content
            )
        }
    )
}