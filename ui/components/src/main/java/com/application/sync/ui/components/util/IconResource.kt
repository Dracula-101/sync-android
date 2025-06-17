package com.application.sync.ui.components.util

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource

sealed class IconResource {
    data class Vector(val imageVector: ImageVector) : IconResource()
    data class Drawable(@DrawableRes val resId: Int) : IconResource()
    data class IconPainter(val painter: Painter) : IconResource()
}

@Composable
fun IconResource.toComposable(
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
) {
    when (this) {
        is IconResource.Vector -> {
            Icon(
                imageVector = imageVector,
                contentDescription = null,
                tint = color,
                modifier = modifier
            )
        }

        is IconResource.Drawable -> {
            Icon(
                painter = painterResource(resId),
                contentDescription = null,
                tint = color,
                modifier = modifier
            )
        }

        is IconResource.IconPainter -> {
            Image(
                painter = painter,
                contentDescription = null,
                colorFilter = if (color != Color.Unspecified) {
                    androidx.compose.ui.graphics.ColorFilter.tint(color)
                } else null,
                modifier = modifier,
            )
        }
    }
}