import com.android.sync.SyncBuildType

plugins {
    alias(libs.plugins.sync.android.application)
    alias(libs.plugins.sync.android.application.compose)
    alias(libs.plugins.sync.android.application.firebase)
    alias(libs.plugins.sync.hilt)
    alias(libs.plugins.kotlin.serialization)
}
android {
    defaultConfig {
        applicationId = "com.android.sync"
        versionCode = 1
        versionName = "0.0.1" // X.Y.Z; X = Major, Y = minor, Z = Patch level
    }

    buildTypes {
        debug {
            applicationIdSuffix = SyncBuildType.DEBUG.applicationIdSuffix
            isMinifyEnabled = false
            isDebuggable = true
        }
        release {
            isMinifyEnabled = true
            applicationIdSuffix = SyncBuildType.RELEASE.applicationIdSuffix
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))

            signingConfig = signingConfigs.named("debug").get()
        }
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

    namespace = "com.android.sync"
}

dependencies {

    implementation(projects.core.design)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material3.adaptive)
    implementation(libs.androidx.compose.material3.adaptive.layout)
    implementation(libs.androidx.compose.material3.adaptive.navigation)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.window.core)
    implementation(libs.kotlinx.serialization.json)

    ksp(libs.hilt.compiler)
}