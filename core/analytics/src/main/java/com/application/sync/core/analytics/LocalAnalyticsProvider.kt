package com.application.sync.core.analytics

import androidx.compose.runtime.staticCompositionLocalOf

val LocalAnalytics = staticCompositionLocalOf<Analytics> {
    NoOpAnalytics()
}
