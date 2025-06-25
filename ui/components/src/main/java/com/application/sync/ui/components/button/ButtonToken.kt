package com.application.sync.ui.components.button

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.application.sync.ui.design.colors.SyncColorScheme

@Composable
internal fun SyncColorScheme.filledButtonColors(
    variant: ButtonVariant = ButtonVariant.Primary,
): ButtonColors {
    return ButtonDefaults.buttonColors(
        containerColor = when (variant) {
            ButtonVariant.Primary -> primary.color
            ButtonVariant.Secondary -> secondary.color
            ButtonVariant.Error -> error.color
        },
        disabledContainerColor = when (variant) {
            ButtonVariant.Primary -> primary.alpha200
            ButtonVariant.Secondary -> secondary.alpha200
            ButtonVariant.Error -> error.alpha200
        },
        contentColor = when (variant) {
            ButtonVariant.Primary -> primary.onColor
            ButtonVariant.Secondary -> secondary.onColor
            ButtonVariant.Error -> error.onColor
        },
        disabledContentColor = when (variant) {
            ButtonVariant.Primary -> primary.alpha400
            ButtonVariant.Secondary -> secondary.alpha400
            ButtonVariant.Error -> error.alpha400
        }
    )
}

@Composable
internal fun SyncColorScheme.outlinedButtonColors(
    variant: ButtonVariant = ButtonVariant.Primary,
): ButtonColors {
    return ButtonDefaults.outlinedButtonColors(
        containerColor = Color.Transparent,
        contentColor = when (variant) {
            ButtonVariant.Primary -> primary.color
            ButtonVariant.Secondary -> secondary.color
            ButtonVariant.Error -> error.color
        },
        disabledContainerColor = Color.Transparent,
        disabledContentColor = when (variant) {
            ButtonVariant.Primary -> primary.alpha400
            ButtonVariant.Secondary -> secondary.alpha400
            ButtonVariant.Error -> error.alpha400
        }
    )
}

@Composable
internal fun SyncColorScheme.outlinedButtonBorderColor(
    variant: ButtonVariant = ButtonVariant.Primary,
    enabled: Boolean = true,
): Color {
    return when (variant) {
        ButtonVariant.Primary -> if (enabled) primary.color else primary.alpha400
        ButtonVariant.Secondary -> if (enabled) secondary.color else secondary.alpha400
        ButtonVariant.Error -> if (enabled) error.color else error.alpha400
    }
}


@Composable
fun SyncColorScheme.textButtonColors(
    variant: ButtonVariant = ButtonVariant.Primary,
): ButtonColors {
    return ButtonDefaults.textButtonColors(
        containerColor = Color.Transparent,
        contentColor = when (variant) {
            ButtonVariant.Primary -> primary.color
            ButtonVariant.Secondary -> secondary.color
            ButtonVariant.Error -> error.color
        },
        disabledContainerColor = Color.Transparent,
        disabledContentColor = when (variant) {
            ButtonVariant.Primary -> primary.alpha400
            ButtonVariant.Secondary -> secondary.alpha400
            ButtonVariant.Error -> error.alpha400
        }
    )
}

@Composable
fun SyncColorScheme.iconButtonColors(
    variant: ButtonVariant = ButtonVariant.Primary,
): IconButtonColors {
    return IconButtonDefaults.iconButtonColors(
        containerColor = Color.Transparent,
        contentColor = when (variant) {
            ButtonVariant.Primary -> primary.color
            ButtonVariant.Secondary -> secondary.color
            ButtonVariant.Error -> error.color
        },
        disabledContainerColor = Color.Transparent,
        disabledContentColor = when (variant) {
            ButtonVariant.Primary -> primary.alpha400
            ButtonVariant.Secondary -> secondary.alpha400
            ButtonVariant.Error -> error.alpha400
        }
    )
}