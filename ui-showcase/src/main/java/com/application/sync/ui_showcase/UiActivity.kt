package com.application.sync.ui_showcase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.application.sync.ui.components.badge.BadgeVariant
import com.application.sync.ui.components.badge.SyncBadge
import com.application.sync.ui.components.badge.SyncOutlineBadge
import com.application.sync.ui.components.button.ButtonVariant
import com.application.sync.ui.components.button.SyncFilledButton
import com.application.sync.ui.components.button.SyncIconButton
import com.application.sync.ui.components.button.SyncLoadingButton
import com.application.sync.ui.components.button.SyncOutlinedButton
import com.application.sync.ui.components.button.SyncTextButton
import com.application.sync.ui.components.checkbox.CheckboxSize
import com.application.sync.ui.components.checkbox.SyncCheckbox
import com.application.sync.ui.components.divider.SyncDivider
import com.application.sync.ui.components.progress.SyncCircularProgressIndicator
import com.application.sync.ui.components.progress.SyncLinearProgressIndicator
import com.application.sync.ui.components.spacing.SyncSpacer
import com.application.sync.ui.components.util.IconResource
import com.application.sync.ui.design.theme.SyncTheme

class UiActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()
        setContent {
            val isDarkTheme = remember { mutableStateOf(true) }
            SyncTheme(isDarkTheme = isDarkTheme.value) {
                Scaffold { padding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .statusBarsPadding()
                            .consumeWindowInsets(padding)
                            .verticalScroll(rememberScrollState())
                            .padding(SyncTheme.spacing.medium)
                            .fillMaxSize(),
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Text(
                                text = "Sync UI",
                                color = SyncTheme.colorScheme.text.primary,
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold,
                            )
                            Switch(
                                checked = isDarkTheme.value,
                                onCheckedChange = { isDarkTheme.value = it },
                                modifier = Modifier.padding(start = 16.dp)
                            )
                        }
                        SyncDivider()
                        TextShowcase()
                        SyncDivider()
                        ButtonShowcase()
                        SyncDivider()
                        BadgeShowcase()
                        SyncDivider()
                        CheckboxShowcase()
                        SyncDivider()
                        ProgressShowcase()
                    }
                }
            }
        }
    }
}

@Composable
fun TextShowcase() {
    Text(
        text = "Display large",
        style = SyncTheme.typography.displayLarge,
    )
    Text(
        text = "Display medium",
        style = SyncTheme.typography.displayMedium,
    )
    Text(
        text = "Display small",
        style = SyncTheme.typography.displaySmall,
    )
    Text(
        text = "Headline large",
        style = SyncTheme.typography.headlineLarge,
    )
    Text(
        text = "Headline medium",
        style = SyncTheme.typography.headlineMedium,
    )
    Text(
        text = "Headline small",
        style = SyncTheme.typography.headlineSmall,
    )
    Text(
        text = "Title large",
        style = SyncTheme.typography.titleLarge,
    )
    Text(
        text = "Title medium",
        style = SyncTheme.typography.titleMedium,
    )
    Text(
        text = "Title small",
        style = SyncTheme.typography.titleSmall,
    )
    Text(
        text = "Body large",
        style = SyncTheme.typography.bodyLarge,
    )
    Text(
        text = "Body medium",
        style = SyncTheme.typography.bodyMedium,
    )
    Text(
        text = "Body small",
        style = SyncTheme.typography.bodySmall,
    )
    Text(
        text = "Label large",
        style = SyncTheme.typography.labelLarge,
    )
    Text(
        text = "Label medium",
        style = SyncTheme.typography.labelMedium,
    )
    Text(
        text = "Label small",
        style = SyncTheme.typography.labelSmall,
    )
}

@Composable
fun ButtonShowcase() {
    Text(
        text = "Outlined Buttons",
        style = SyncTheme.typography.titleLarge,
    )
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        ButtonVariant.entries.forEach { variant ->
            SyncOutlinedButton(variant = variant) {
                Text(text = variant.name)
            }
        }
        Box(modifier = Modifier.fillMaxWidth())
        ButtonVariant.entries.forEach { variant ->
            SyncOutlinedButton(variant = variant, enabled = false) {
                Text(text = variant.name)
            }
        }
        Box(modifier = Modifier.fillMaxWidth())
        ButtonVariant.entries.forEach { variant ->
            SyncOutlinedButton(
                onClick = {},
                variant = variant,
                icon = IconResource.Drawable(R.drawable.done_24),
            ) {
                Text(text = variant.name)
            }
        }
    }
    SyncSpacer()
    Text(
        text = "Filled Buttons",
        style = SyncTheme.typography.titleLarge,
    )
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        ButtonVariant.entries.forEach { variant ->
            SyncFilledButton(variant = variant) {
                Text(text = variant.name)
            }
        }
        Box(modifier = Modifier.fillMaxWidth())
        ButtonVariant.entries.forEach { variant ->
            SyncFilledButton(variant = variant, enabled = false) {
                Text(text = variant.name)
            }
        }
    }
    SyncSpacer()
    Text(
        text = "Text Buttons",
        style = SyncTheme.typography.titleLarge,
    )
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        SyncTextButton(onClick = {}) {
            Text(text = "Default")
        }
        SyncTextButton(onClick = {}, enabled = false) {
            Text(text = "Default")
        }
    }
    SyncSpacer()
    Text(
        text = "Icon Buttons",
        style = SyncTheme.typography.titleLarge,
    )
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        SyncIconButton(
            onClick = {},
            size = SyncTheme.spacing.large,
            icon = IconResource.Drawable(R.drawable.done_24),
        )
        SyncIconButton(
            onClick = {},
            enabled = false,
            size = SyncTheme.spacing.large,
            icon = IconResource.Drawable(R.drawable.done_24),
        )
    }
    SyncSpacer()
    val isLoading = remember { mutableStateOf(true) }
    Text(
        text = "Loading Buttons",
        style = SyncTheme.typography.titleLarge,
    )
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        SyncLoadingButton(isLoading = isLoading.value) {
            Text(text = "Loading Button")
        }
        Button(
            onClick = { isLoading.value = !isLoading.value },
        ) {
            Text(text = "Toggle")
        }
    }
}

@Composable
fun BadgeShowcase() {
    Text(
        text = "Badges",
        style = SyncTheme.typography.titleLarge,
    )
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        BadgeVariant.entries.forEach { variant ->
            SyncBadge(
                // icon = IconResource.Drawable(R.drawable.done_24),
                text = variant.name,
                variant = variant,
            )
        }
    }
    Text(
        text = "Outline Badges",
        style = SyncTheme.typography.titleLarge,
    )
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        BadgeVariant.entries.forEach { variant ->
            SyncOutlineBadge(
                text = variant.name,
                variant = variant,
            )
        }
    }
}

@Composable
fun CheckboxShowcase() {
    Text(
        text = "Checkboxes",
        style = SyncTheme.typography.titleLarge,
    )
    Column {
        CheckboxSize.entries.forEach { size ->
            Row {
                val checkedState = remember { mutableStateOf(false) }
                SyncCheckbox(
                    checked = { checkedState.value },
                    onCheckedChange = { checkedState.value = it },
                    size = size,
                )
                SyncCheckbox(
                    checked = { true },
                    onCheckedChange = {},
                    enabled = false,
                    size = size,
                )
                SyncCheckbox(
                    checked = { false },
                    onCheckedChange = {},
                    enabled = false,
                    size = size,
                )
            }
        }
    }
}

@Composable
fun ProgressShowcase() {
    Text(
        text = "Indicators",
        style = SyncTheme.typography.titleLarge,
    )
    SyncSpacer()
    SyncLinearProgressIndicator()
    SyncSpacer()
    SyncCircularProgressIndicator()
    SyncSpacer()
}