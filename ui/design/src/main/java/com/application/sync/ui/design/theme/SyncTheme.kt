package com.application.sync.ui.design.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.application.sync.ui.design.colors.DarkColorScheme
import com.application.sync.ui.design.colors.LightColorScheme
import com.application.sync.ui.design.colors.SyncColorScheme
import com.application.sync.ui.design.colors.dynamicTheme
import com.application.sync.ui.design.colors.toMaterialColorScheme
import com.application.sync.ui.design.dimension.SyncDimensions
import com.application.sync.ui.design.dimension.syncDimensions
import com.application.sync.ui.design.shape.SyncShapes
import com.application.sync.ui.design.shape.syncShapes
import com.application.sync.ui.design.spacing.SyncSpacing
import com.application.sync.ui.design.spacing.syncSpacing
import com.application.sync.ui.design.type.SyncTypography
import com.application.sync.ui.design.type.syncTypography
import com.application.sync.ui.design.type.toMaterialTypography

object SyncTheme {
    /**
     * Retrieves the current [SyncComponentColors].
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

    /**
     * Retrieves the current [SyncSpacing].
     */
    val spacing: SyncSpacing
        @Composable
        @ReadOnlyComposable
        get() = LocalSyncSpacing.current

    /**
     * Retrieves the current [SyncDimensions].
     */
    val dimen: SyncDimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalSyncDimensions.current
}

@Composable
fun SyncTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    dynamic: Boolean = false,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val syncColorScheme = when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && dynamic -> {
            dynamicTheme(
                if (isDarkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(
                    context
                )
            )
        }
        isDarkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.setDecorFitsSystemWindows(window, false)
            val insetsController = WindowCompat.getInsetsController(window, view)
            insetsController.isAppearanceLightStatusBars = !isDarkTheme
            insetsController.isAppearanceLightNavigationBars = !isDarkTheme
            window.statusBarColor = Color.Transparent.toArgb()
            window.navigationBarColor = Color.Transparent.toArgb()
        }
    }

    CompositionLocalProvider(
        LocalSyncColorScheme provides syncColorScheme,
        LocalSyncShapes provides syncShapes,
        LocalSyncTypography provides syncTypography,
        LocalSyncSpacing provides syncSpacing,
        LocalSyncDimensions provides syncDimensions
    ) {
        MaterialTheme(
            colorScheme = syncColorScheme.toMaterialColorScheme(),
            typography = syncTypography.toMaterialTypography(),
            content = content
        )
    }
}


val LocalSyncColorScheme: ProvidableCompositionLocal<SyncColorScheme> =
    compositionLocalOf { DarkColorScheme }

val LocalSyncShapes: ProvidableCompositionLocal<SyncShapes> =
    compositionLocalOf { syncShapes }

val LocalSyncTypography: ProvidableCompositionLocal<SyncTypography> =
    compositionLocalOf { syncTypography }

val LocalSyncSpacing: ProvidableCompositionLocal<SyncSpacing> =
    compositionLocalOf { syncSpacing }

val LocalSyncDimensions: ProvidableCompositionLocal<SyncDimensions> =
    compositionLocalOf { syncDimensions }