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
    size: Dp = SyncTheme.dimen.icon.medium,
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
        colors = SyncTheme.colorScheme.iconButtonColors(),
        content = {
            icon.toComposable(
                modifier = Modifier.size(size),
            )
        }
    )
}
