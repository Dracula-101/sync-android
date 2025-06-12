import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose)
}

android {
    namespace = "com.application.sync.core.ui"
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
    // Compose BOM
    implementation(platform(libs.androidx.compose.bom))

    // Core Android libraries
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)

    // Compose Essentials
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material3.adaptive)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)

    //Navigation
    implementation(libs.androidx.navigation.compose)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)

}

//implementation(libs.androidx.appcompat)
//implementation(platform(libs.androidx.compose.bom))
//implementation(libs.androidx.compose.animation)
//implementation(libs.androidx.compose.material3)
//implementation(libs.androidx.compose.material3.adaptive)
//implementation(libs.androidx.compose.runtime)
//implementation(libs.androidx.compose.ui)
//implementation(libs.androidx.compose.ui.graphics)
//implementation(libs.androidx.compose.ui.tooling)
//implementation(libs.androidx.compose.ui.tooling.preview)
//implementation(libs.androidx.core.ktx)
//implementation(libs.androidx.navigation.compose)
//implementation(libs.kotlinx.serialization)
//implementation(libs.kotlinx.coroutines.core)
//implementation(libs.kotlinx.collections.immutable)