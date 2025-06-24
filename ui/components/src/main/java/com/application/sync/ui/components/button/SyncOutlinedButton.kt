package com.application.sync.ui.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.application.sync.ui.components.util.IconResource
import com.application.sync.ui.components.util.toComposable
import com.application.sync.ui.design.theme.SyncTheme

@Composable
fun SyncOutlinedButton(
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    variant: ButtonVariant = ButtonVariant.Primary,
    icon: IconResource? = null,
    content: @Composable () -> Unit = {},
) {
    OutlinedButton(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        colors = SyncTheme.colorScheme.outlinedButtonColors(variant),
        shape = SyncTheme.shapes.button,
        border = BorderStroke(
            width = SyncTheme.dimen.border.small,
            color = SyncTheme.colorScheme.outlinedButtonBorderColor(variant)
        ),
        contentPadding = PaddingValues(
            horizontal = SyncTheme.spacing.padding.medium,
            vertical = SyncTheme.spacing.padding.small,
        ),
        content = {
            Box(
                modifier = Modifier.then(
                    if (icon != null) Modifier
                        .padding(end = SyncTheme.spacing.padding.extraSmall)
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

