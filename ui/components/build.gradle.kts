plugins {
    alias(libs.plugins.sync.android.library)
    alias(libs.plugins.sync.android.library.compose)
}

android {
    namespace = "com.application.sync.ui.components"
}

dependencies {
    implementation(projects.ui.design)

    // Compose BOM
    implementation(platform(libs.androidx.compose.bom))

    // Compose Essentials
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
}