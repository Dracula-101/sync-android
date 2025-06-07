plugins {
    alias(libs.plugins.sync.android.library)
    alias(libs.plugins.sync.android.library.compose)
}

android {
    namespace = "com.android.sync.core.design"
}

dependencies {
    api(libs.androidx.compose.material3)
    implementation(libs.coil.kt.compose)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.tooling.preview)
}