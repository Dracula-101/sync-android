package com.application.sync.ui.components.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
fun SyncOutlineBadge(
    text: String,
    modifier: Modifier = Modifier,
    variant: BadgeVariant = BadgeVariant.Default,
    icon: IconResource? = null,
) {
    val outlineColor = when (variant) {
        BadgeVariant.Default -> SyncTheme.colorScheme.stroke.primary
        BadgeVariant.Secondary -> SyncTheme.colorScheme.stroke.secondary
        BadgeVariant.Success -> SyncTheme.colorScheme.status.success
        BadgeVariant.Warning -> SyncTheme.colorScheme.status.warning
        BadgeVariant.Error -> SyncTheme.colorScheme.status.error
    }

    Box(
        modifier = modifier
            .padding(vertical = SyncTheme.spacing.extraSmall)
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = SyncTheme.spacing.dividerThin,
                color = outlineColor,
                shape = RoundedCornerShape(12.dp),
            )
            .background(color = outlineColor.copy(alpha = 0.2f))
            .padding(
                horizontal = SyncTheme.spacing.small,
                vertical = SyncTheme.spacing.extraSmall,
            ),
    ) {
        ProvideTextStyle(SyncTheme.typography.labelMedium) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(SyncTheme.spacing.gapTiny),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .then(
                        if (icon != null) Modifier.padding(end = SyncTheme.spacing.extraSmall)
                        else Modifier
                    )
            ) {
                if (icon != null) {
                    Box(
                        modifier = Modifier.size(SyncTheme.typography.labelMedium.fontSize.value.dp * 1.5f),
                    ) {
                        icon.toComposable()
                    }
                }
                Text(
                    text = text,
                    style = SyncTheme.typography.labelMedium,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
    }

}