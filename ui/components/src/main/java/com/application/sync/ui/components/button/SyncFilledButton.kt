package com.application.sync.ui.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.application.sync.ui.design.theme.SyncTheme


@Composable
fun SyncFilledButton(
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = SyncTheme.colorScheme.filledButton.background,
            disabledContainerColor = SyncTheme.colorScheme.filledButton.disabledBackground,
            contentColor = SyncTheme.colorScheme.filledButton.content,
            disabledContentColor = SyncTheme.colorScheme.filledButton.disabledContent,
        ),
        shape = SyncTheme.shapes.button,
        contentPadding = PaddingValues(
            horizontal = SyncTheme.spacing.medium,
            vertical = SyncTheme.spacing.small,
        ),
        interactionSource = null,
        content = {
            ProvideTextStyle(
                SyncTheme.typography.bodyLarge,
                content = content
            )
        }
    )
}