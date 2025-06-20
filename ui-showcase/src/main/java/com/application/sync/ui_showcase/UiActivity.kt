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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Api
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Keyboard
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.application.sync.ui.components.dialog.SyncActionDialog
import com.application.sync.ui.components.dialog.SyncCompactActionDialog
import com.application.sync.ui.components.dialog.SyncIconActionDialog
import com.application.sync.ui.components.divider.SyncDivider
import com.application.sync.ui.components.dropdown.DropdownMenuGroup
import com.application.sync.ui.components.dropdown.DropdownMenuItem
import com.application.sync.ui.components.dropdown.DropdownMenuLabel
import com.application.sync.ui.components.dropdown.DropdownMenuSeparator
import com.application.sync.ui.components.dropdown.DropdownMenuShortcut
import com.application.sync.ui.components.dropdown.SyncDropdownMenu
import com.application.sync.ui.components.progress.SyncCircularProgressIndicator
import com.application.sync.ui.components.progress.SyncLinearProgressIndicator
import com.application.sync.ui.components.spacing.SyncSpacer
import com.application.sync.ui.components.switch.SyncSwitch
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
                        SyncDivider()
                        SwitchShowcase()
                        SyncDivider()
                        DropdownMenuShowcase()
                        SyncDivider()
                        DialogShowcase()
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
        SyncLoadingButton(isLoading = isLoading.value, variant = ButtonVariant.Secondary) {
            Text(text = "Loading Button")
        }
        SyncLoadingButton(
            isLoading = isLoading.value,
            variant = ButtonVariant.Success,
        ) {
            Text(text = "Loading Button")
        }
        SyncLoadingButton(
            isLoading = isLoading.value,
            variant = ButtonVariant.Warning,
        ) {
            Text(text = "Loading Button")
        }
        SyncLoadingButton(
            isLoading = isLoading.value,
            variant = ButtonVariant.Error,
        ) {
            Text(text = "Loading Button")
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
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        SyncCircularProgressIndicator()
        (10..100 step 10).forEach { progress ->
            SyncCircularProgressIndicator(
                progress = { progress / 100f },
            )
        }
    }
    SyncSpacer()
}

@Composable
fun SwitchShowcase() {
    Text(
        text = "Switches",
        style = SyncTheme.typography.titleLarge,
    )
    SyncSpacer()
    val isChecked = remember { mutableStateOf(false) }
    Row {
        SyncSwitch(
            checked = { isChecked.value },
            onCheckedChange = { isChecked.value = it },
        )
        SyncSpacer()
        SyncSwitch(
            checked = { false },
            onCheckedChange = {},
            enabled = false,
        )
        SyncSpacer()
        SyncSwitch(
            checked = { true },
            onCheckedChange = {},
            enabled = false,
        )
    }
}

@Composable
fun DropdownMenuShowcase() {
    var expanded by remember { mutableStateOf(false) }
    Text(
        text = "Dropdown Menu",
        style = SyncTheme.typography.titleLarge,
    )
    SyncSpacer()
    Box {
        SyncOutlinedButton(
            onClick = { expanded = true },
        ) {
            Text(text = "Open Menu")
        }

        SyncDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            DropdownMenuLabel("My Account")
            DropdownMenuGroup {
                DropdownMenuItem(
                    text = { Text("Profile") },
                    onClick = { expanded = false },
                    leading = { Icon(Icons.Default.Person, contentDescription = null) },
                    trailingIcon = { DropdownMenuShortcut("⇧⌘P") },
                )
                DropdownMenuItem(
                    text = { Text("Billing") },
                    onClick = { expanded = false },
                    leading = { Icon(Icons.Default.CreditCard, contentDescription = null) },
                    trailingIcon = { DropdownMenuShortcut("⌘B") },
                )
                DropdownMenuItem(
                    text = { Text("Settings") },
                    onClick = { expanded = false },
                    leading = { Icon(Icons.Default.Settings, contentDescription = null) },
                    trailingIcon = { DropdownMenuShortcut("⌘S") }
                )
                DropdownMenuItem(
                    text = { Text("Keyboard shortcuts") },
                    onClick = { expanded = false },
                    leading = { Icon(Icons.Default.Keyboard, contentDescription = null) },
                    trailingIcon = { DropdownMenuShortcut("⌘K") }
                )
            }
            DropdownMenuSeparator()
            DropdownMenuLabel("Manage")
            DropdownMenuGroup {
                DropdownMenuItem(
                    text = { Text("Team") },
                    onClick = { expanded = false },
                    leading = { Icon(Icons.Default.Group, contentDescription = null) }
                )
                DropdownMenuItem(
                    text = { Text("New Team") },
                    onClick = { expanded = false },
                    leading = { Icon(Icons.Default.Add, contentDescription = null) },
                    trailingIcon = { DropdownMenuShortcut("⌘+T") }
                )
            }
            DropdownMenuSeparator()
            DropdownMenuItem(
                text = { Text("GitHub") },
                onClick = { expanded = false },
                leading = { Icon(Icons.Default.Code, contentDescription = null) }
            )
            DropdownMenuItem(
                text = { Text("Support") },
                onClick = { expanded = false },
                leading = { Icon(Icons.AutoMirrored.Filled.Help, contentDescription = null) }
            )
            DropdownMenuItem(
                text = { Text("API") },
                onClick = { },
                enabled = false,
                leading = { Icon(Icons.Default.Api, contentDescription = null) }
            )
            DropdownMenuSeparator()
            DropdownMenuItem(
                text = { Text("Log out") },
                onClick = { expanded = false },
                leading = { Icon(Icons.AutoMirrored.Filled.Logout, contentDescription = null) },
                trailingIcon = { DropdownMenuShortcut("⇧⌘Q") }
            )
        }
    }
}

@Composable
fun ShowDialogShowcase(
    button: String,
    title: String,
    content: String,
    primaryAction: String,
    secondaryAction: String? = null,
    isDestructive: Boolean = false
) {
    var showDialog by remember { mutableStateOf(false) }
    SyncFilledButton(
        onClick = { showDialog = true },
    ) {
        Text(button)
    }
    if (showDialog) {
        SyncActionDialog(
            onDismissRequest = { showDialog = false },
            title = title,
            content = content,
            primaryActionText = primaryAction,
            onPrimaryAction = {},
            secondaryActionText = secondaryAction,
            onSecondaryAction = {},
            destructive = isDestructive
        )
    }
}

@Composable
fun ShowCompactDialogShowcase(
    button: String,
    title: String,
    content: String,
    primaryAction: String,
    secondaryAction: String? = null,
    isDestructive: Boolean = false
) {
    var showDialog by remember { mutableStateOf(false) }
    SyncFilledButton(
        onClick = { showDialog = true },
    ) {
        Text(button)
    }
    if (showDialog) {
        SyncCompactActionDialog(
            onDismissRequest = { showDialog = false },
            title = title,
            content = content,
            primaryActionText = primaryAction,
            onPrimaryAction = {},
            secondaryActionText = secondaryAction,
            onSecondaryAction = {},
            destructive = isDestructive
        )
    }
}

@Composable
fun ShowIconActionDialogShowcase(
    button: String,
    title: String,
    content: String,
    icon: IconResource? = null,
    primaryAction: String? = null,
    secondaryAction: String? = null
) {
    var showDialog by remember { mutableStateOf(false) }
    SyncFilledButton(
        onClick = { showDialog = true },
    ) {
        Text(button)
    }
    if (showDialog) {
        SyncIconActionDialog(
            onDismissRequest = { showDialog = false },
            title = title,
            message = content,
            icon = icon,
            positiveButtonText = primaryAction,
            negativeButtonText = secondaryAction,
            onPositiveButtonClick = {},
            onNegativeButtonClick = {}
        )
    }
}

@Composable
fun DialogShowcase() {
    Text(
        text = "Dialogs",
        style = SyncTheme.typography.titleLarge,
    )
    SyncSpacer()
    Text(
        text = "Action Dialogs",
        style = SyncTheme.typography.bodyLarge,
    )
    FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        ShowDialogShowcase(
            button = "Delete Item",
            title = "Delete Item",
            content = "Are you sure you want to delete this item? This action cannot be undone.",
            primaryAction = "Delete",
            secondaryAction = "Cancel",
            isDestructive = true
        )
        ShowDialogShowcase(
            button = "Success Dialog",
            title = "Success!",
            content = "Your changes have been saved successfully.",
            primaryAction = "OK"
        )
        ShowDialogShowcase(
            button = "Confirm Save",
            title = "Save Changes?",
            content = "You have unsaved changes. Would you like to save them before continuing?",
            primaryAction = "Save",
            secondaryAction = "Discard"
        )
        ShowDialogShowcase(
            button = "Single Action Dialog",
            title = "Network Error",
            content = "Unable to connect to the server. Please check your internet connection and try again.",
            primaryAction = "Retry"
        )
    }
    SyncSpacer()
    Text(
        text = "Compact Action Dialogs",
        style = SyncTheme.typography.bodyLarge,
    )
    FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        ShowCompactDialogShowcase(
            button = "Delete",
            title = "Delete Item",
            content = "Are you sure you want to delete this item? This action cannot be undone.",
            primaryAction = "Delete",
            secondaryAction = "Cancel",
            isDestructive = true
        )
        ShowCompactDialogShowcase(
            button = "Success Dialog",
            title = "Success!",
            content = "Your changes have been saved successfully.",
            primaryAction = "OK"
        )
        ShowCompactDialogShowcase(
            button = "Confirm Save",
            title = "Save Changes?",
            content = "You have unsaved changes. Would you like to save them before continuing?",
            primaryAction = "Save",
            secondaryAction = "Discard"
        )
        ShowCompactDialogShowcase(
            button = "Single Action Dialog",
            title = "Network Error",
            content = "Unable to connect to the server. Please check your internet connection and try again.",
            primaryAction = "Retry"
        )
    }
    SyncSpacer()
    Text(
        text = "Icon Action Dialogs",
        style = SyncTheme.typography.bodyLarge,
    )
    FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        ShowIconActionDialogShowcase(
            button = "Delete Item",
            title = "Delete Item",
            content = "Are you sure you want to delete this item? This action cannot be undone.",
            icon = IconResource.Drawable(R.drawable.delete_24),
            primaryAction = "Delete",
            secondaryAction = "Cancel",
        )
        ShowIconActionDialogShowcase(
            button = "Success Dialog",
            title = "Success!",
            content = "Your changes have been saved successfully.",
            icon = IconResource.Drawable(R.drawable.done_24),
            primaryAction = "OK"
        )
        ShowIconActionDialogShowcase(
            button = "Confirm Save",
            title = "Save Changes?",
            content = "You have unsaved changes. Would you like to save them before continuing?",
            icon = IconResource.Drawable(R.drawable.save_24),
            primaryAction = "Save",
            secondaryAction = "Discard"
        )
        ShowIconActionDialogShowcase(
            button = "Single Action Dialog",
            title = "Network Error",
            content = "Unable to connect to the server. Please check your internet connection and try again.",
            icon = IconResource.Drawable(R.drawable.error_24),
            primaryAction = "Retry"
        )
    }
}