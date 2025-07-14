package com.application.sync

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.application.sync.core.analytics.Analytics
import com.application.sync.core.analytics.AnalyticsEvent
import com.application.sync.core.analytics.LocalAnalytics
import com.application.sync.ui.components.button.SyncTextButton
import com.application.sync.ui.design.theme.SyncTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var analytics: Analytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Track app opened using new searchable API
        analytics.trackEvent(AnalyticsEvent.AppEvent.opened("launcher"))

        // Track screen view using new searchable API
        analytics.trackEvent(AnalyticsEvent.ScreenEvent.view(AnalyticsEvent.ScreenEvent.HOME))

        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            CompositionLocalProvider(
                LocalAnalytics provides analytics
            ) {
                val analytics = LocalAnalytics.current
                SyncTheme {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(SyncTheme.colorScheme.surface.color)
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 16.dp, vertical = 64.dp),
                        ) {
                            Surface(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                shape = SyncTheme.shapes.card,
                                color = SyncTheme.colorScheme.surface.high,
                            ) {
                                Text(
                                    text = "Welcome to Sync!",
                                    style = SyncTheme.typography.headlineMedium,
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                        }

                        // Demonstrate searchable analytics events
                        SyncTextButton(
                            onClick = {
                                // Easy to search: AnalyticsEvent.ButtonEvent
                                analytics.trackEvent(
                                    AnalyticsEvent.ButtonEvent.custom(
                                        "welcome_click",
                                        mapOf("screen" to "main")
                                    )
                                )
                            },
                        ) {
                            Text(
                                text = "Welcome Button",
                                style = SyncTheme.typography.bodyLarge,
                                modifier = Modifier.padding(8.dp)
                            )
                        }

                        SyncTextButton(
                            onClick = {
                                // Easy to search: AnalyticsEvent.NavigationEvent
                                analytics.trackEvent(
                                    AnalyticsEvent.NavigationEvent.screenTransition(
                                        "main",
                                        "profile"
                                    )
                                )
                            },
                        ) {
                            Text(
                                text = "Go to Profile",
                                style = SyncTheme.typography.bodyLarge,
                                modifier = Modifier.padding(8.dp)
                            )
                        }

                        SyncTextButton(
                            onClick = {
                                // Easy to search: AnalyticsEvent.ContentEvent
                                analytics.trackEvent(
                                    AnalyticsEvent.ContentEvent.postLiked(
                                        "post_123",
                                        "user_456",
                                        true
                                    )
                                )
                            },
                        ) {
                            Text(
                                text = "Like Post",
                                style = SyncTheme.typography.bodyLarge,
                                modifier = Modifier.padding(8.dp)
                            )
                        }

                        SyncTextButton(
                            onClick = {
                                // Easy to search: AnalyticsEvent.UserEvent
                                analytics.trackEvent(
                                    AnalyticsEvent.UserEvent.followed("user_789", true, "profile")
                                )
                            },
                        ) {
                            Text(
                                text = "Follow User",
                                style = SyncTheme.typography.bodyLarge,
                                modifier = Modifier.padding(8.dp)
                            )
                        }

                        SyncTextButton(
                            onClick = {
                                // Easy to search: AnalyticsEvent.ErrorEvent
                                analytics.trackEvent(
                                    AnalyticsEvent.ErrorEvent.networkError(
                                        "/api/posts",
                                        500,
                                        "Internal Server Error"
                                    )
                                )
                            },
                        ) {
                            Text(
                                text = "Simulate Error",
                                style = SyncTheme.typography.bodyLarge,
                                modifier = Modifier.padding(8.dp)
                            )
                        }

                        SyncTextButton(
                            onClick = {
                                // Easy to search: AnalyticsEvent.TimingEvent
                                analytics.trackEvent(
                                    AnalyticsEvent.TimingEvent.loadTime(
                                        "feed",
                                        "initial_load",
                                        1250,
                                        "home_screen"
                                    )
                                )
                            },
                        ) {
                            Text(
                                text = "Track Performance",
                                style = SyncTheme.typography.bodyLarge,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}