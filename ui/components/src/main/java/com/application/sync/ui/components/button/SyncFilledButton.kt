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
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    variant: ButtonVariant = ButtonVariant.Default,
    content: @Composable () -> Unit = {},
) {
    val buttonTheme = SyncTheme.colorScheme.filledButton
    val colors = when (variant) {
        ButtonVariant.Default -> buttonTheme
        ButtonVariant.Secondary -> buttonTheme.copy(
            background = SyncTheme.colorScheme.stroke.secondary.copy(
                alpha = 0.7f
            )
        )

        ButtonVariant.Success -> buttonTheme.copy(
            background = SyncTheme.colorScheme.status.success.copy(
                alpha = 0.7f
            )
        )

        ButtonVariant.Warning -> buttonTheme.copy(
            background = SyncTheme.colorScheme.status.warning.copy(
                alpha = 0.7f
            )
        )

        ButtonVariant.Error -> buttonTheme.copy(
            background = SyncTheme.colorScheme.status.error.copy(
                alpha = 0.7f
            )
        )
    }
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.background,
            disabledContainerColor = colors.disabledBackground,
            contentColor = colors.content,
            disabledContentColor = colors.disabledContent,
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