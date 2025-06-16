package com.application.sync.ui.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.application.sync.ui.components.util.IconResource
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
    val buttonTheme = SyncTheme.colorScheme.outlinedButton
    val colors = when (variant) {
        ButtonVariant.Default -> buttonTheme
        ButtonVariant.Secondary -> buttonTheme.copy(
            border = SyncTheme.colorScheme.stroke.secondary,
            background = SyncTheme.colorScheme.background.secondary,
            content = SyncTheme.colorScheme.text.secondary,
        )

        ButtonVariant.Success -> buttonTheme.copy(
            border = SyncTheme.colorScheme.status.success,
            background = SyncTheme.colorScheme.background.success,
            content = SyncTheme.colorScheme.status.success,
        )

        ButtonVariant.Warning -> buttonTheme.copy(
            border = SyncTheme.colorScheme.status.warning,
            background = SyncTheme.colorScheme.background.warning,
            content = SyncTheme.colorScheme.status.warning,
        )

        ButtonVariant.Error -> buttonTheme.copy(
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
            Box(
                modifier = Modifier.then(
                    if (icon != null) Modifier
                        .padding(end = SyncTheme.spacing.gapTiny)
                        .size(SyncTheme.typography.bodyLarge.fontSize.value.dp * 1.25f)
                    else Modifier
                )
            ) {
                when (icon) {
                    is IconResource.Vector -> {
                        Icon(
                            imageVector = icon.imageVector,
                            contentDescription = null,
                        )
                    }

                    is IconResource.Drawable -> {
                        Icon(
                            painter = painterResource(icon.resId),
                            contentDescription = null,
                        )
                    }

                    is IconResource.IconPainter -> {
                        Image(
                            painter = icon.painter,
                            contentDescription = null,
                        )
                    }

                    null -> {}
                }
            }
            ProvideTextStyle(
                value = SyncTheme.typography.bodyLarge,
                content = content
            )
        }
    )
}

