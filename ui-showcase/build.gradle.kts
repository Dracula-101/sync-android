plugins {
    alias(libs.plugins.sync.android.application)
    alias(libs.plugins.sync.android.application.compose)
    alias(libs.plugins.sync.android.application.flavors)
}

android {
    namespace = "com.application.sync.ui_showcase"
}

dependencies {
    lintChecks(projects.lint)
    implementation(projects.lint)

    implementation(projects.ui.design)
    implementation(projects.ui.components)

    // Core
    implementation(libs.androidx.activity.compose)

    // Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material.icons.core)
    implementation(libs.androidx.compose.material.icons.extended)
}