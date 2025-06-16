package com.application.sync.ui.components.util

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

sealed class IconResource {
    data class Vector(val imageVector: ImageVector) : IconResource()
    data class Drawable(@DrawableRes val resId: Int) : IconResource()
    data class IconPainter(val painter: Painter) : IconResource()
}