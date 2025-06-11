package com.android.sync.core.design.component.button

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.sync.core.design.theme.SyncTheme

@Composable
fun SyncOutlinedButton(
    onClick: () -> Unit,
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
            color = if (enabled) colors.border.copy(alpha = 0.25f) else colors.disabledBorder
        ),
        contentPadding = PaddingValues(
            horizontal = SyncTheme.spacing.medium,
            vertical = SyncTheme.spacing.small,
        ),
        content = { content() }
    )
}

enum class OutlinedButtonVariant {
    Default, Secondary, Success, Warning, Error
}

@Composable
@Preview(apiLevel = 34)
@Preview(apiLevel = 34, uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun SyncOutlinedButtonPreview() {
    SyncTheme {
        Column(
            modifier = Modifier
                .background(SyncTheme.colorScheme.background.primary)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButtonVariant.entries.forEach { variant ->
                SyncOutlinedButton(
                    onClick = { /* Do nothing */ },
                    variant = variant
                ) {
                    Text(text = "Outlined Button - $variant")
                }
            }
        }
    }
}


@Composable
@Preview(apiLevel = 34, showBackground = true)
@Preview(apiLevel = 34, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun SyncOutlinedDisabledButtonPreview() {
    SyncTheme {
        Column(
            modifier = Modifier
                .background(SyncTheme.colorScheme.background.primary)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButtonVariant.entries.forEach { variant ->
                SyncOutlinedButton(
                    onClick = { /* Do nothing */ },
                    variant = variant,
                    enabled = false
                ) {
                    Text(text = "Outlined Button - $variant")
                }
            }
        }
    }
}