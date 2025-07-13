import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.sync.android.library)
    alias(libs.plugins.sync.android.hilt)
    alias(libs.plugins.sync.android.retrofit)
}

android {
    namespace = "com.application.sync.core.network"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.valueOf("VERSION_${libs.versions.jvmTarget.get()}")
        targetCompatibility = JavaVersion.valueOf("VERSION_${libs.versions.jvmTarget.get()}")
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.fromTarget(libs.versions.jvmTarget.get()))
    }
}

dependencies {
    // Network
    implementation(platform(libs.square.retrofit.bom))
    implementation(libs.square.okhttp)
    implementation(libs.square.okhttp.logging)
    implementation(libs.square.retrofit)
    implementation(libs.square.retrofit.gson)

    // Logging
    implementation(libs.timber)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
}