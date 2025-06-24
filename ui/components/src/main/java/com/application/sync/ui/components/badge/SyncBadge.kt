package com.application.sync.ui.components.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.application.sync.ui.components.util.IconResource
import com.application.sync.ui.components.util.toComposable
import com.application.sync.ui.design.theme.SyncTheme

@Composable
fun SyncBadge(
    text: String,
    modifier: Modifier = Modifier,
    variant: BadgeVariant = BadgeVariant.Primary,
    icon: IconResource? = null,
) {
    val backgroundColor = when (variant) {
        BadgeVariant.Primary -> SyncTheme.colorScheme.primary.color
        BadgeVariant.Secondary -> SyncTheme.colorScheme.secondary.color
        BadgeVariant.Error -> SyncTheme.colorScheme.error.color
    }
    Box(
        modifier = modifier
            .padding(vertical = SyncTheme.spacing.padding.extraSmall)
            .clip(RoundedCornerShape(12.dp))
            .background(color = backgroundColor.copy(alpha = 0.7f))
            .padding(
                horizontal = SyncTheme.spacing.padding.small,
                vertical = SyncTheme.spacing.padding.extraSmall,
            ),
    ) {
        ProvideTextStyle(SyncTheme.typography.labelMedium) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(SyncTheme.spacing.padding.extraSmall),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .then(
                        if (icon != null) Modifier.padding(end = SyncTheme.spacing.padding.extraSmall)
                        else Modifier
                    )
            ) {
                icon?.toComposable(
                    modifier = Modifier
                        .size(SyncTheme.typography.labelMedium.fontSize.value.dp * 1.5f)
                )
                Text(
                    text = text,
                    style = SyncTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}

