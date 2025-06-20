package com.application.sync.ui.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.application.sync.ui.components.util.IconResource
import com.application.sync.ui.components.util.toComposable
import com.application.sync.ui.design.colors.SyncColorScheme
import com.application.sync.ui.design.theme.SyncTheme

@Composable
fun SyncOutlinedButton(
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    variant: ButtonVariant = ButtonVariant.Default,
    icon: IconResource? = null,
    content: @Composable () -> Unit = {},
) {
    val colors = SyncTheme.colorScheme.outlinedButtonColors(variant)
    OutlinedButton(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        colors = colors,
        shape = SyncTheme.shapes.button,
        border = BorderStroke(
            width = SyncTheme.dimen.border.medium,
            color = colors.containerColor.copy(alpha = if (enabled) 1f else 0.5f),
        ),
        contentPadding = PaddingValues(
            horizontal = SyncTheme.spacing.padding.medium,
            vertical = SyncTheme.spacing.padding.small,
        ),
        content = {
            Box(
                modifier = Modifier.then(
                    if (icon != null) Modifier
                        .padding(end = SyncTheme.spacing.gap.tiny)
                        .size(SyncTheme.typography.bodyLarge.fontSize.value.dp * 1.25f)
                    else Modifier
                )
            ) {
                icon?.toComposable()
            }
            ProvideTextStyle(
                value = SyncTheme.typography.bodyLarge,
                content = content
            )
        }
    )
}

@Composable
fun SyncColorScheme.outlinedButtonColors(
    variant: ButtonVariant = ButtonVariant.Default,
    disabledAlpha: Float = 0.5f,
): ButtonColors {
    val color = when (variant) {
        ButtonVariant.Default -> ButtonColors(
            containerColor = primary.color,
            disabledContainerColor = primary.color,
            contentColor = primary.color,
            disabledContentColor = primary.color,
        )

        ButtonVariant.Secondary -> ButtonColors(
            containerColor = secondary.containerColor,
            disabledContainerColor = secondary.containerColor,
            contentColor = secondary.onContainerColor,
            disabledContentColor = secondary.onContainerColor,
        )

        ButtonVariant.Success -> ButtonColors(
            containerColor = success.color,
            disabledContainerColor = success.color,
            contentColor = success.onColor,
            disabledContentColor = success.onColor,
        )

        ButtonVariant.Error -> ButtonColors(
            containerColor = error.color,
            disabledContainerColor = error.color,
            contentColor = error.onColor,
            disabledContentColor = error.onColor,
        )
    }
    return color
}
