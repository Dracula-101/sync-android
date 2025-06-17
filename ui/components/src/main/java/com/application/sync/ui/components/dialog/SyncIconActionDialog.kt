package com.application.sync.ui.components.dialog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.application.sync.ui.components.button.SyncFilledButton
import com.application.sync.ui.components.button.SyncOutlinedButton
import com.application.sync.ui.components.spacing.SyncSpacer
import com.application.sync.ui.components.spacing.SyncSpacerSize
import com.application.sync.ui.components.util.IconResource
import com.application.sync.ui.components.util.toComposable
import com.application.sync.ui.design.theme.SyncTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SyncIconActionDialog(
    onDismissRequest: () -> Unit,
    title: String,
    message: String,
    icon: IconResource? = null,
    positiveButtonText: String? = null,
    negativeButtonText: String? = null,
    onPositiveButtonClick: (() -> Unit)? = null,
    onNegativeButtonClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    BasicAlertDialog(
        onDismissRequest = onDismissRequest,
        properties = androidx.compose.ui.window.DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false
        ),
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = SyncTheme.shapes.dialog,
                colors = CardDefaults.cardColors(
                    containerColor = SyncTheme.colorScheme.dialog.background
                ),
                border = BorderStroke(
                    width = 2.dp,
                    color = SyncTheme.colorScheme.background.tertiary.copy(alpha = 0.5f)
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                        .padding(top = 12.dp, bottom = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    SyncSpacer(size = SyncSpacerSize.Small)
                    icon?.toComposable(
                        modifier = Modifier
                            .size(80.dp)
                            .align(Alignment.CenterHorizontally),
                        color = SyncTheme.colorScheme.icon.primary
                    )
                    Text(
                        text = title,
                        style = SyncTheme.typography.headlineMedium,
                        modifier = Modifier
                            .padding(horizontal = 8.dp),
                        color = SyncTheme.colorScheme.text.primary,
                    )
                    SyncSpacer(size = SyncSpacerSize.Small)
                    Text(
                        text = message,
                        style = SyncTheme.typography.titleMedium,
                        color = SyncTheme.colorScheme.text.secondary,
                        modifier = Modifier
                            .padding(horizontal = 8.dp),
                        textAlign = TextAlign.Center
                    )
                    SyncSpacer()
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (negativeButtonText != null && onNegativeButtonClick != null) {
                            SyncOutlinedButton(
                                onClick = {
                                    onNegativeButtonClick()
                                    onDismissRequest()
                                },
                            ) {
                                Text(
                                    text = negativeButtonText,
                                    style = SyncTheme.typography.bodyLarge,
                                )
                            }
                        }
                        if (positiveButtonText != null && onPositiveButtonClick != null) {
                            SyncFilledButton(
                                onClick = {
                                    onPositiveButtonClick()
                                    onDismissRequest()
                                },
                            ) {
                                Text(
                                    text = positiveButtonText,
                                    style = SyncTheme.typography.bodyLarge,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}