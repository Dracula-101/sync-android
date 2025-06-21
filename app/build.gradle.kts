import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.konan.properties.loadProperties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
    alias(libs.plugins.gms)
    alias(libs.plugins.firebase.crashlytics)
    alias(libs.plugins.firebase.perf)
}

val secretPropertiesFile = rootProject.file("secrets.properties")
val secretProperties = if (secretPropertiesFile.exists()) {
    loadProperties(secretPropertiesFile.path)
} else {
    throw IllegalStateException("Secret properties file not found: ${secretPropertiesFile.path}")
}

android {
    namespace = "com.application.sync"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.application.sync"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    lint {
        checkReleaseBuilds = false
        abortOnError = false
        checkDependencies = true
    }

    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false

            buildConfigField(
                "String",
                "BACKEND_URL",
                "\"${secretProperties.getProperty("DEV_BACKEND_URL", "http://localhost:8080")}\""
            )

            manifestPlaceholders["crashlytics_enabled"] = "false"
        }

        release {
            isDebuggable = false
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            buildConfigField(
                "String",
                "BACKEND_URL",
                "\"${secretProperties.getProperty("PROD_BACKEND_URL")}\""
            )

            manifestPlaceholders["crashlytics_enabled"] = "true"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.valueOf("VERSION_${libs.versions.jvmTarget.get()}")
        targetCompatibility = JavaVersion.valueOf("VERSION_${libs.versions.jvmTarget.get()}")
    }

    buildFeatures {
        compose = true
        buildConfig = true
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

room {
    schemaDirectory("$projectDir/schemas")
}

dependencies {

    lintChecks(projects.lint)
    implementation(projects.lint)

    implementation(projects.core.network)
    implementation(projects.ui.design)
    implementation(projects.ui.components)

    implementation(libs.accompanist.permissions)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material3.adaptive)
    implementation(libs.androidx.compose.material3.adaptive.layout)
    implementation(libs.androidx.compose.material3.adaptive.navigation)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.core.security.crypto)
    implementation(libs.androidx.dataStore)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.window.core)
    implementation(libs.androidx.work.ktx)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.coil.kt.compose)
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.performance)
    implementation(libs.hilt.android)
    implementation(libs.hilt.ext.work)
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.datetime)
    implementation(libs.room.ktx)
    implementation(libs.room.runtime)
    implementation(platform(libs.square.retrofit.bom))
    implementation(libs.square.okhttp)
    implementation(libs.square.okhttp.logging)
    implementation(libs.square.retrofit)
    implementation(libs.square.retrofit.gson)
    implementation(libs.timber)
    ksp(libs.hilt.compiler)
    ksp(libs.hilt.ext.compiler)
    ksp(libs.room.compiler)
}