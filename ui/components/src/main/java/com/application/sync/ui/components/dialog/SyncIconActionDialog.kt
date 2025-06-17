package com.application.sync.ui.components.dialog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.application.sync.ui.components.R
import com.application.sync.ui.components.util.IconResource
import com.application.sync.ui.design.theme.SyncTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SyncIconActionDialog(
    onDismissRequest: () -> Unit,
    title: String,
    message: String,
    icon: IconResource? = null,
    confirmButton: @Composable () -> Unit,
    dismissButton: @Composable () -> Unit,
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
                            colorFilter = ColorFilter.tint(SyncTheme.colorScheme.text.primary),
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp)
                            .padding(top = 24.dp, bottom = 20.dp),
                    ) {

                    }
                }
            }
        }
    }
}