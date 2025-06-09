package com.android.sync.core.design.component.button

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
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
    content: @Composable () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = SyncTheme.colorScheme.outlinedButton.background,
            disabledContainerColor = SyncTheme.colorScheme.outlinedButton.disabledBackground,
            contentColor = SyncTheme.colorScheme.outlinedButton.content,
            disabledContentColor = SyncTheme.colorScheme.outlinedButton.disabledContent,
        ),
        shape = SyncTheme.shapes.button,
        border = BorderStroke(
            width = 1.75.dp,
            color = if (enabled) {
                SyncTheme.colorScheme.outlinedButton.border
            } else {
                SyncTheme.colorScheme.outlinedButton.disabledBorder
            },
        ),
        contentPadding = PaddingValues(
            horizontal = SyncTheme.spacing.medium,
            vertical = SyncTheme.spacing.small,
        ),
        content = { content() }
    )
}

@Composable
@Preview(apiLevel = 34)
@Preview(apiLevel = 34, uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun SyncOutlinedButtonPreview() {
    SyncOutlinedButton(onClick = { /* Do nothing */ }) {
        Text(
            text = "Button",
        )
    }
}

@Composable
@Preview(apiLevel = 34)
private fun SyncOutlinedDisabledButtonPreview() {
    SyncOutlinedButton(onClick = { /* Do nothing */ }, enabled = false) {
        Text(
            text = "Disabled Button",
        )
    }
}