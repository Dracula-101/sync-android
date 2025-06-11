package com.android.sync.core.design.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.platform.LocalContext
import com.android.sync.core.design.colors.SyncColorScheme
import com.android.sync.core.design.colors.darkSyncColorScheme
import com.android.sync.core.design.colors.dynamicSyncColorScheme
import com.android.sync.core.design.colors.lightSyncColorScheme
import com.android.sync.core.design.colors.toMaterialColorScheme
import com.android.sync.core.design.shape.SyncShapes
import com.android.sync.core.design.shape.syncShapes
import com.android.sync.core.design.spacing.SyncSpacing
import com.android.sync.core.design.spacing.syncSpacing
import com.android.sync.core.design.type.SyncTypography
import com.android.sync.core.design.type.syncTypography
import com.android.sync.core.design.type.toMaterialTypography

object SyncTheme {
    /**
     * Retrieves the current [SyncColorScheme].
     */
    val colorScheme: SyncColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalSyncColorScheme.current

    /**
     * Retrieves the current [SyncShapes].
     */
    val shapes: SyncShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalSyncShapes.current

    /**
     * Retrieves the current [SyncTypography].
     */
    val typography: SyncTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalSyncTypography.current

    val spacing: SyncSpacing
        @Composable
        @ReadOnlyComposable
        get() = LocalSyncSpacing.current
}

@Composable
fun SyncTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val materialColorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (isDarkTheme) {
                dynamicDarkColorScheme(context = context)
            } else {
                dynamicLightColorScheme(context = context)
            }
        }

        isDarkTheme -> darkColorScheme()
        else -> lightColorScheme()
    }

    val syncColorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            dynamicSyncColorScheme(
                materialColorScheme = materialColorScheme,
                isDarkTheme = isDarkTheme,
            )
        }

        isDarkTheme -> darkSyncColorScheme
        else -> lightSyncColorScheme
    }

    CompositionLocalProvider(
        LocalSyncColorScheme provides syncColorScheme,
        LocalSyncShapes provides syncShapes,
        LocalSyncTypography provides syncTypography,
        LocalSyncSpacing provides syncSpacing,
    ) {
        MaterialTheme(
            colorScheme = syncColorScheme.toMaterialColorScheme(defaultColorScheme = materialColorScheme),
            typography = syncTypography.toMaterialTypography(),
            content = content
        )
    }
}


val LocalSyncColorScheme: ProvidableCompositionLocal<SyncColorScheme> =
    compositionLocalOf { lightSyncColorScheme }

val LocalSyncShapes: ProvidableCompositionLocal<SyncShapes> =
    compositionLocalOf { syncShapes }

val LocalSyncTypography: ProvidableCompositionLocal<SyncTypography> =
    compositionLocalOf { syncTypography }

val LocalSyncSpacing: ProvidableCompositionLocal<SyncSpacing> =
    compositionLocalOf { syncSpacing }