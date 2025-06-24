package com.application.sync.ui.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.application.sync.ui.design.theme.SyncTheme


@Composable
fun SyncFilledButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    variant: ButtonVariant = ButtonVariant.Primary,
    content: @Composable () -> Unit = {},
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        colors = SyncTheme.colorScheme.filledButtonColors(variant),
        shape = SyncTheme.shapes.button,
        contentPadding = PaddingValues(
            horizontal = SyncTheme.spacing.padding.medium,
            vertical = SyncTheme.spacing.padding.small,
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