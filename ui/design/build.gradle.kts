plugins {
    alias(libs.plugins.sync.android.library)
    alias(libs.plugins.sync.android.library.compose)
}

android {
    namespace = "com.application.sync.ui.design"
}


dependencies {
    lintPublish(projects.lint)
    // Compose BOM
    implementation(platform(libs.androidx.compose.bom))

    // Core Android libraries
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)

    // Compose Essentials
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)

}