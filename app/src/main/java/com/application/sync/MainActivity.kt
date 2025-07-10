package com.application.sync

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.application.sync.ui.design.theme.SyncTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            SyncTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(SyncTheme.colorScheme.surface.color)
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
            }
        }
    }
}