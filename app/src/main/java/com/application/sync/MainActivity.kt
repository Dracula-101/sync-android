package com.application.sync

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.application.sync.core.design.component.button.OutlinedButtonVariant
import com.application.sync.core.design.component.button.SyncFilledButton
import com.application.sync.core.design.component.button.SyncOutlinedButton
import com.application.sync.core.design.theme.SyncTheme
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        setContent {
            val isDarkTheme = remember { mutableStateOf(true) }
            val isEnabled = remember { mutableStateOf(true) }
            SyncTheme(isDarkTheme = isDarkTheme.value) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(SyncTheme.colorScheme.background.primary),
                    content = { innerPadding ->
                        Box(
                            modifier = Modifier
                                .padding(innerPadding)
                                .padding(8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .verticalScroll(rememberScrollState()),
                                verticalArrangement = Arrangement.spacedBy(4.dp),
                            ) {
                                Text(
                                    text = "Sync",
                                    style = SyncTheme.typography.displayLarge,
                                    color = SyncTheme.colorScheme.text.primary,
                                )
                                SyncFilledButton(
                                    onClick = {
                                        isDarkTheme.value = !isDarkTheme.value
                                    },
                                ) {
                                    Text(text = "Change Theme")
                                }
                                SyncFilledButton(
                                    onClick = {
                                        isEnabled.value = !isEnabled.value
                                    },
                                ) {
                                    Text(text = "Toggle Enabled State")
                                }
                                OutlinedButtonVariant.entries.forEach { variant ->
                                    SyncOutlinedButton(
                                        onClick = {
                                            Timber.d("Clicked $variant")
                                        },
                                        variant = variant,
                                        enabled = isEnabled.value,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(text = "Outlined Button - $variant")
                                    }
                                }
                            }
                        }
                    }
                )
            }
        }
    }
}