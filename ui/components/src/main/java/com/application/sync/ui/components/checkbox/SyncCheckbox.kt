package com.application.sync.ui.components.checkbox

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PathMeasure
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.application.sync.ui.design.theme.SyncTheme


@Composable
fun SyncCheckbox(
    checked: () -> Boolean,
    onCheckedChange: (Boolean) -> Unit,
    enabled: Boolean = true,
    size: CheckboxSize = CheckboxSize.Medium,
    modifier: Modifier = Modifier,
) {
    val isChecked = checked()
    val colorScheme = SyncTheme.colorScheme

    val (checkboxSize, clickTargetSize, cornerRadius, strokeWidth, checkmarkSize) = when (size) {
        CheckboxSize.Small -> CheckboxDimensions(16.dp, 44.dp, 3.dp, 1.5.dp, 10.dp)
        CheckboxSize.Medium -> CheckboxDimensions(20.dp, 44.dp, 4.dp, 1.5.dp, 12.dp)
        CheckboxSize.Large -> CheckboxDimensions(24.dp, 48.dp, 5.dp, 2.dp, 16.dp)
    }

    val animatedProgress by animateFloatAsState(
        targetValue = if (isChecked) 1f else 0f,
        animationSpec = tween(
            durationMillis = 150,
            easing = FastOutSlowInEasing
        ),
        label = "checkboxAnimation"
    )

    val backgroundColor = when {
        !enabled -> colorScheme.background.secondary
        isChecked -> colorScheme.stroke.primary
        else -> colorScheme.input.background
    }

    val borderColor = when {
        !enabled -> colorScheme.stroke.secondary.copy(alpha = 0.5f)
        isChecked -> colorScheme.stroke.primary
        else -> colorScheme.stroke.secondary
    }

    val checkColor = if (enabled) {
        colorScheme.filledButton.content
    } else {
        colorScheme.text.disabled
    }

    Box(
        modifier = modifier
            .size(clickTargetSize)
            .clickable(
                enabled = enabled,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                onCheckedChange(!isChecked)
            },
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(checkboxSize)
                .clip(RoundedCornerShape(cornerRadius))
                .background(backgroundColor)
                .border(
                    width = strokeWidth,
                    color = borderColor,
                    shape = RoundedCornerShape(cornerRadius)
                ),
            contentAlignment = Alignment.Center
        ) {
            Canvas(
                modifier = Modifier.size(checkmarkSize)
            ) {
                if (animatedProgress > 0f) {
                    val path = Path().apply {
                        moveTo(this@Canvas.size.width * 0.2f, this@Canvas.size.height * 0.5f)
                        lineTo(this@Canvas.size.width * 0.45f, this@Canvas.size.height * 0.75f)
                        lineTo(this@Canvas.size.width * 0.85f, this@Canvas.size.height * 0.25f)
                    }

                    drawPath(
                        path = path,
                        color = checkColor,
                        style = Stroke(
                            width = strokeWidth.toPx(),
                            cap = StrokeCap.Round,
                            join = StrokeJoin.Round,
                            pathEffect = PathEffect.dashPathEffect(
                                intervals = floatArrayOf(
                                    path.length,
                                    path.length
                                ),
                                phase = path.length * (1f - animatedProgress)
                            )
                        )
                    )
                }
            }
        }
    }
}

private data class CheckboxDimensions(
    val checkboxSize: Dp,
    val clickTargetSize: Dp,
    val cornerRadius: Dp,
    val strokeWidth: Dp,
    val checkmarkSize: Dp
)

private val Path.length: Float
    get() {
        val pathMeasure = PathMeasure()
        pathMeasure.setPath(this, false)
        return pathMeasure.length
    }