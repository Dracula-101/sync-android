package com.application.sync.ui.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.application.sync.ui.design.colors.SyncColorScheme
import com.application.sync.ui.design.theme.SyncTheme


@Composable
fun SyncFilledButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    variant: ButtonVariant = ButtonVariant.Default,
    content: @Composable () -> Unit = {},
) {
    val colors = SyncTheme.colorScheme.filledButtonColors(variant)
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        colors = colors,
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


@Composable
fun SyncColorScheme.filledButtonColors(
    variant: ButtonVariant = ButtonVariant.Default,
    disabledAlpha: Float = 0.5f,
): ButtonColors {
    return when (variant) {
        ButtonVariant.Default -> ButtonColors(
            contentColor = primary.onColor,
            disabledContentColor = primary.onColor.copy(alpha = disabledAlpha),
            containerColor = primary.color,
            disabledContainerColor = primary.color.copy(alpha = disabledAlpha),
        )

        ButtonVariant.Secondary -> ButtonColors(
            containerColor = primary.containerColor,
            disabledContainerColor = primary.containerColor.copy(alpha = disabledAlpha),
            contentColor = primary.onContainerColor,
            disabledContentColor = primary.onContainerColor.copy(alpha = disabledAlpha),
        )

        ButtonVariant.Success -> ButtonColors(
            containerColor = success.color,
            disabledContainerColor = success.color.copy(alpha = disabledAlpha),
            contentColor = success.onColor,
            disabledContentColor = success.onColor.copy(alpha = disabledAlpha),
        )

        ButtonVariant.Error -> ButtonColors(
            containerColor = error.color,
            disabledContainerColor = error.color.copy(alpha = disabledAlpha),
            contentColor = error.onColor,
            disabledContentColor = error.onColor.copy(alpha = disabledAlpha),
        )
    }
}