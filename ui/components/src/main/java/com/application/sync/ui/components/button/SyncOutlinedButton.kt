package com.application.sync.ui.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.application.sync.ui.design.theme.SyncTheme

@Composable
fun SyncOutlinedButton(
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    variant: OutlinedButtonVariant = OutlinedButtonVariant.Default,
    content: @Composable () -> Unit
) {
    val buttonTheme = SyncTheme.colorScheme.outlinedButton
    val colors = when (variant) {
        OutlinedButtonVariant.Default -> buttonTheme
        OutlinedButtonVariant.Secondary -> buttonTheme.copy(
            border = SyncTheme.colorScheme.stroke.secondary,
            background = SyncTheme.colorScheme.background.secondary,
            content = SyncTheme.colorScheme.text.secondary,
        )

        OutlinedButtonVariant.Success -> buttonTheme.copy(
            border = SyncTheme.colorScheme.status.success,
            background = SyncTheme.colorScheme.background.success,
            content = SyncTheme.colorScheme.status.success,
        )

        OutlinedButtonVariant.Warning -> buttonTheme.copy(
            border = SyncTheme.colorScheme.status.warning,
            background = SyncTheme.colorScheme.background.warning,
            content = SyncTheme.colorScheme.status.warning,
        )

        OutlinedButtonVariant.Error -> buttonTheme.copy(
            border = SyncTheme.colorScheme.status.error,
            background = SyncTheme.colorScheme.background.error,
            content = SyncTheme.colorScheme.status.error,
        )
    }
    val borderColor = if (enabled) {
        colors.border.copy(alpha = 0.25f)
    } else {
        colors.disabledBorder
    }
    OutlinedButton(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = colors.background.copy(0.5f),
            disabledContainerColor = colors.disabledBackground,
            contentColor = colors.content,
            disabledContentColor = colors.disabledContent,
        ),
        shape = SyncTheme.shapes.button,
        border = BorderStroke(
            width = 1.75.dp,
            color = borderColor,
        ),
        contentPadding = PaddingValues(
            horizontal = SyncTheme.spacing.medium,
            vertical = SyncTheme.spacing.small,
        ),
        content = {
            ProvideTextStyle(
                value = SyncTheme.typography.bodyLarge,
                content = content
            )
        }
    )
}

enum class OutlinedButtonVariant {
    Default, Secondary, Success, Warning, Error
}
