package com.application.sync.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.Vendor
import com.android.tools.lint.detector.api.CURRENT_API

class SyncThemeIssueRegistry : IssueRegistry() {
    override val issues = listOf(
        SyncThemeDetector.ISSUE
    )

    override val api: Int = CURRENT_API

    override val minApi: Int = 8

    override val vendor: Vendor = Vendor(
        vendorName = "Sync",
        feedbackUrl = "https://github.com/Dracula-101/sync/issues",
    )
}