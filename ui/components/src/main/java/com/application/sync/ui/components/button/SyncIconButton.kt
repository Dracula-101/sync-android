package com.application.sync.ui.components.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.application.sync.ui.components.util.IconResource
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
            disabledContentColor = SyncTheme.colorScheme.text.disabled,
            disabledContainerColor = SyncTheme.colorScheme.background.secondary,
        ),
        content = {
            when (icon) {
                is IconResource.Vector -> {
                    Icon(
                        imageVector = icon.imageVector,
                        contentDescription = null,
                        modifier = Modifier.size(size)
                    )
                }

                is IconResource.Drawable -> {
                    Icon(
                        painter = painterResource(icon.resId),
                        contentDescription = null,
                        modifier = Modifier.size(size)
                    )
                }

                is IconResource.IconPainter -> {
                    Image(
                        painter = icon.painter,
                        contentDescription = null,
                        modifier = Modifier.size(size)
                    )
                }
            }
        }
    )
}
