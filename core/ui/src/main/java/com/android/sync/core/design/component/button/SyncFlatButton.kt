package com.android.sync.core.design.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.sync.core.design.theme.SyncTheme

@Composable
fun SyncFlatButton(
    onClick: () -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = SyncTheme.colorScheme.filledButton.background,
            disabledContainerColor = SyncTheme.colorScheme.filledButton.disabledBackground,
            contentColor = SyncTheme.colorScheme.filledButton.content,
            disabledContentColor = SyncTheme.colorScheme.filledButton.disabledContent,
        ),
        shape = SyncTheme.shapes.button,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp,
            hoveredElevation = 0.dp,
            focusedElevation = 0.dp
        ),
        contentPadding = PaddingValues(
            horizontal = SyncTheme.spacing.medium,
            vertical = SyncTheme.spacing.small,
        ),
        content = { content() }
    )
}