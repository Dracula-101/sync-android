package com.application.sync.ui.components.dialog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.application.sync.ui.components.R
import com.application.sync.ui.components.button.ButtonVariant
import com.application.sync.ui.components.button.SyncFilledButton
import com.application.sync.ui.components.button.SyncOutlinedButton
import com.application.sync.ui.components.spacing.SyncSpacer
import com.application.sync.ui.components.spacing.SyncSpacerSize
import com.application.sync.ui.design.theme.SyncTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SyncActionDialog(
    onDismissRequest: () -> Unit,
    title: String,
    content: String,
    primaryActionText: String,
    onPrimaryAction: () -> Unit,
    secondaryActionText: String? = null,
    onSecondaryAction: (() -> Unit)? = null,
    destructive: Boolean = false,
    modifier: Modifier = Modifier
) {
    val dialogColors = SyncTheme.colorScheme.dialogColors()

    BasicAlertDialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false
        )
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
                colors = SyncTheme.colorScheme.dialogCardColors(),
                border = BorderStroke(
                    width = 2.dp,
                    color = dialogColors.border.copy(alpha = 0.5f)
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Box {
                    IconButton(
                        onClick = onDismissRequest,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(12.dp),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_close_24),
                            contentDescription = "Close dialog",
                            modifier = Modifier
                                .height(18.dp)
                                .width(18.dp),
                            colorFilter = ColorFilter.tint(dialogColors.content),
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp)
                            .padding(top = 24.dp, bottom = 20.dp),
                    ) {
                        Text(
                            text = title,
                            style = SyncTheme.typography.headlineMedium,
                            color = dialogColors.title,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.fillMaxWidth()
                        )
                        SyncSpacer(size = SyncSpacerSize.Small)
                        Text(
                            text = content,
                            style = SyncTheme.typography.bodyLarge,
                            color = dialogColors.content.copy(alpha = 0.8f),
                            textAlign = TextAlign.Start,
                            modifier = Modifier.fillMaxWidth()
                        )
                        SyncSpacer(size = SyncSpacerSize.Large)
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            if (secondaryActionText != null && onSecondaryAction != null) {
                                SyncOutlinedButton(
                                    onClick = {
                                        onSecondaryAction()
                                        onDismissRequest()
                                    },
                                    modifier = Modifier.wrapContentHeight(),
                                ) {
                                    Text(
                                        text = secondaryActionText,
                                        style = SyncTheme.typography.bodyLarge,
                                    )
                                }

                                Spacer(modifier = Modifier.width(12.dp))
                            }
                            SyncFilledButton(
                                onClick = {
                                    onPrimaryAction()
                                    onDismissRequest()
                                },
                                variant = if (destructive) {
                                    ButtonVariant.Error
                                } else {
                                    ButtonVariant.Primary
                                },
                                modifier = Modifier.wrapContentHeight(),
                            ) {
                                Text(
                                    text = primaryActionText,
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SyncActionDialog(
    onDismissRequest: () -> Unit,
    title: @Composable () -> Unit,
    content: @Composable () -> Unit,
    actions: @Composable RowScope.() -> Unit,
    actionsAlignment: Alignment.Horizontal = Alignment.End,
    modifier: Modifier = Modifier
) {
    val dialogColors = SyncTheme.colorScheme.dialogColors()

    BasicAlertDialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false
        )
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
                colors = SyncTheme.colorScheme.dialogCardColors(),
                border = BorderStroke(
                    width = 2.dp,
                    color = dialogColors.border.copy(alpha = 0.5f)
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Box {
                    IconButton(
                        onClick = onDismissRequest,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(12.dp),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_close_24),
                            contentDescription = "Close dialog",
                            modifier = Modifier
                                .height(18.dp)
                                .width(18.dp),
                            colorFilter = ColorFilter.tint(dialogColors.content),
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp)
                            .padding(top = 24.dp, bottom = 20.dp),
                    ) {
                        ProvideTextStyle(
                            value = SyncTheme.typography.headlineMedium.copy(
                                color = dialogColors.title,
                            ),
                            content = title,
                        )
                        SyncSpacer(size = SyncSpacerSize.Small)
                        ProvideTextStyle(
                            value = SyncTheme.typography.bodyLarge.copy(
                                color = dialogColors.content.copy(alpha = 0.8f),
                            ),
                            content = content,
                        )
                        SyncSpacer(size = SyncSpacerSize.Large)
                        ProvideTextStyle(
                            value = SyncTheme.typography.bodyLarge.copy(
                                color = dialogColors.content
                            )
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(
                                    12.dp,
                                    actionsAlignment
                                ),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                actions()
                            }
                        }
                    }
                }
            }
        }
    }
}