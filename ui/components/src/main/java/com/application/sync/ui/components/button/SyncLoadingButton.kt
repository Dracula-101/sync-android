package com.application.sync.ui.components.button

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.application.sync.ui.design.theme.SyncTheme

@Composable
fun SyncLoadingButton(
    onClick: () -> Unit = {},
    isLoading: Boolean = true,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    variant: ButtonVariant = ButtonVariant.Primary,
    content: @Composable () -> Unit = {},
) {
    val buttonTheme = SyncTheme.colorScheme.outlinedButtonColors(variant)
    SyncOutlinedButton(
        onClick = onClick,
        enabled = enabled && !isLoading,
        modifier = modifier,
        variant = variant,
        content = {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(SyncTheme.spacing.radius.medium),
                    strokeWidth = 2.dp,
                    color = buttonTheme.disabledContainerColor,
                )
                Spacer(Modifier.size(SyncTheme.spacing.gap.extraSmall))
            }
            content()
        },
    )
}