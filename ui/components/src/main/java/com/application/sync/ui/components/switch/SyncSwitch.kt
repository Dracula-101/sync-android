package com.application.sync.ui.components.switch

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.application.sync.ui.design.theme.SyncTheme

/**
 * A modern switch component following shadcn/ui design principles with improved visual hierarchy.
 *
 * @param checked Function that returns the current checked state
 * @param onCheckedChange Function called when the switch state should change
 * @param modifier Modifier to be applied to the switch
 * @param enabled Whether the switch is enabled for interaction
 * @param width Width of the switch track
 * @param height Height of the switch track
 * @param thumbSize Size of the switch thumb
 * @param thumbPadding Padding for thumb positioning
 * @param interactionSource The MutableInteractionSource representing the stream of interactions
 */
@Composable
fun SyncSwitch(
    checked: () -> Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    width: Dp = 44.dp,
    height: Dp = 24.dp,
    thumbSize: Dp = 20.dp,
    thumbPadding: Dp = 2.dp,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val isChecked = checked()

    val trackRadius = height / 2
    val thumbTravel = width - thumbSize - (thumbPadding * 2)

    val thumbOffset by animateFloatAsState(
        targetValue = if (isChecked) (thumbPadding + thumbTravel).value else thumbPadding.value,
        animationSpec = tween(durationMillis = 150),
        label = "thumb_position"
    )

    val trackColor = when {
        !enabled && isChecked -> SyncTheme.colorScheme.stroke.secondary.copy(alpha = 0.5f)
        !enabled -> SyncTheme.colorScheme.background.tertiary
        isChecked -> SyncTheme.colorScheme.stroke.primary
        else -> SyncTheme.colorScheme.input.background
    }

    val thumbColor = when {
        !enabled -> SyncTheme.colorScheme.text.disabled
        else -> SyncTheme.colorScheme.background.secondary
    }

    Box(
        modifier = modifier
            .size(width = width, height = height)
            .clip(RoundedCornerShape(trackRadius))
            .background(trackColor),
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .offset(x = thumbOffset.dp)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    enabled = enabled,
                    role = Role.Switch,
                    onClick = { onCheckedChange(!isChecked) }
                )
                .size(thumbSize)
                .clip(CircleShape)
                .background(thumbColor)
        )
    }
}