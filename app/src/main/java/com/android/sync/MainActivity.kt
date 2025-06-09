package com.android.sync

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.android.sync.core.design.component.button.SyncFilledButton
import com.android.sync.core.design.component.button.SyncOutlinedButton
import com.android.sync.core.design.theme.SyncTheme
import com.android.sync.core.network.model.SyncClientConfig
import com.android.sync.core.network.syncServiceClient
import kotlinx.coroutines.launch
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        setContent {
            val isDarkTheme = remember { mutableStateOf(false) }
            val isEnabled = remember { mutableStateOf(true) }
            val service = remember {
                syncServiceClient(
                    config = SyncClientConfig(
                        baseUrl = BuildConfig.BACKEND_URL,
                        httpBodyLogging = true, // Enable logging for debugging purposes
                    )
                )
            }
            val coroutineScope = rememberCoroutineScope()

            SyncTheme(isDarkTheme = isDarkTheme.value) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(SyncTheme.colorScheme.background.primary),
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
                                coroutineScope.launch {
                                    val result = service.auth.loginWithEmail(
                                        email = "pratikpujari1000@gmail.com",
                                        password = "Pratik@123"
                                    )
                                    Timber.d("Login Result: $result")
                                }
                            }
                        ) {
                            Text(text = "Click Me")
                        }
                    }
                }
            }
        }
    }
}