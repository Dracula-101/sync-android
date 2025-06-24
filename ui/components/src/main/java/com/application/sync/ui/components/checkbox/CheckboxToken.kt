package com.application.sync.ui.components.checkbox

import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import com.application.sync.ui.design.colors.SyncColorScheme

@Composable
fun SyncColorScheme.checkboxColors(): CheckboxColors {
    return CheckboxDefaults.colors(
        checkedColor = primary.color,
        uncheckedColor = primary.color,
        disabledCheckedColor = primary.alpha400,
        disabledUncheckedColor = primary.alpha400,
        checkmarkColor = primary.onColor,
        disabledIndeterminateColor = primary.alpha200
    )
}