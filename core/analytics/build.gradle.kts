plugins {
    alias(libs.plugins.sync.android.library)
    alias(libs.plugins.sync.android.library.compose)
    alias(libs.plugins.sync.android.hilt)
}

android {
    namespace = "com.application.sync.core.analytics"
}

dependencies {
    implementation(libs.androidx.compose.runtime)

    productionImplementation(platform(libs.firebase.bom))
    productionImplementation(libs.firebase.analytics)
}