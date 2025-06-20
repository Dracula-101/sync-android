package com.application.sync.ui.components.divider

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.application.sync.ui.design.theme.SyncTheme

@Composable
fun SyncDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    spacing: Dp = SyncTheme.spacing.padding.small,
    color: Color = SyncTheme.colorScheme.surfaceVariant.color,
    orientation: SyncDividerOrientation = SyncDividerOrientation.Horizontal,
) {
    when (orientation) {
        SyncDividerOrientation.Horizontal -> {
            HorizontalDivider(
                modifier = modifier
                    .padding(vertical = spacing)
                    .clip(SyncTheme.shapes.progressIndicator),
                thickness = thickness,
                color = color
            )
        }

        SyncDividerOrientation.Vertical -> {
            VerticalDivider(
                modifier = modifier
                    .padding(horizontal = spacing)
                    .clip(SyncTheme.shapes.progressIndicator),
                thickness = thickness,
                color = color
            )
        }
    }
}

enum class SyncDividerOrientation {
    Horizontal,
    Vertical;
}