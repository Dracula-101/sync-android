package com.application.sync.core.design.component.button

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.application.sync.core.design.theme.SyncTheme

@Composable
fun SyncFilledButton(
    onClick: () -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = SyncTheme.colorScheme.filledButton.background,
            disabledContainerColor = SyncTheme.colorScheme.filledButton.disabledBackground,
            contentColor = SyncTheme.colorScheme.filledButton.content,
            disabledContentColor = SyncTheme.colorScheme.filledButton.disabledContent,
        ),
        shape = SyncTheme.shapes.button,
        contentPadding = PaddingValues(
            horizontal = SyncTheme.spacing.medium,
            vertical = SyncTheme.spacing.small,
        ),
        interactionSource = null,
        content = { content() }
    )
}

@Composable
@Preview(apiLevel = 34)
private fun SyncFilledButtonPreview() {
    SyncFilledButton(onClick = { /* Do nothing */ }) {
        Text(
            text = "Button",
            style = SyncTheme.typography.bodyLarge,
            color = SyncTheme.colorScheme.text.primary
        )
    }
}

@Preview(apiLevel = 34, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SyncFilledDisabledButtonPreview() {
    SyncFilledButton(onClick = { /* Do nothing */ }, enabled = false) {
        Text(
            text = "Disabled Button",
            style = SyncTheme.typography.bodyLarge,
            color = SyncTheme.colorScheme.text.disabled
        )
    }
}