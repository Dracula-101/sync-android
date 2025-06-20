package com.application.sync.ui.components.button

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.application.sync.ui.components.util.IconResource
import com.application.sync.ui.components.util.toComposable
import com.application.sync.ui.design.theme.SyncTheme

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SyncIconButton(
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    icon: IconResource,
    size: Dp = SyncTheme.spacing.iconMedium,
    modifier: Modifier = Modifier,
) {
    IconButton(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        shapes = IconButtonDefaults.shapes(
            shape = SyncTheme.shapes.button,
            pressedShape = SyncTheme.shapes.button,
        ),
        colors = IconButtonDefaults.iconButtonColors(
            contentColor = SyncTheme.colorScheme.icon.primary,
            containerColor = SyncTheme.colorScheme.background.secondary,
            disabledContentColor = SyncTheme.colorScheme.outlinedButton.disabledContent,
            disabledContainerColor = SyncTheme.colorScheme.outlinedButton.disabledBackground,
        ),
        content = {
            icon.toComposable(
                modifier = Modifier.size(size),
            )
        }
    )
}
