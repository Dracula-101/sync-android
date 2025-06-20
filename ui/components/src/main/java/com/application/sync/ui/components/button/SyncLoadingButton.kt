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
    variant: ButtonVariant = ButtonVariant.Default,
    content: @Composable () -> Unit = {},
) {
    SyncOutlinedButton(
        onClick = onClick,
        enabled = enabled && !isLoading,
        modifier = modifier,
        variant = variant,
        content = {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(SyncTheme.dimen.height.tiny),
                    strokeWidth = 2.dp,
                    color = SyncTheme.colorScheme.primary.onContainerColor.copy(alpha = 0.7f),
                )
                Spacer(Modifier.size(SyncTheme.spacing.padding.small))
            }
            content()
        },
    )
}