import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose)
}

android {
    namespace = "com.application.sync.ui.components"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.valueOf("VERSION_${libs.versions.jvmTarget.get()}")
        targetCompatibility = JavaVersion.valueOf("VERSION_${libs.versions.jvmTarget.get()}")
    }

    buildFeatures {
        compose = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.fromTarget(libs.versions.jvmTarget.get()))
    }
}


dependencies {

    implementation(projects.ui.design)

    // Compose BOM
    implementation(platform(libs.androidx.compose.bom))

    // Compose Essentials
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
}