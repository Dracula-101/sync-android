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
        versionName = "0.0.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables.useSupportLibrary = true

        buildConfigField("String", "APP_NAME", "\"Sync\"")
    }

    // Product Flavors Configuration
    flavorDimensions += listOf("environment")

    productFlavors {
        create("development") {
            dimension = "environment"
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"

            buildConfigField(
                "String",
                "BACKEND_URL",
                "\"${secretProperties.getProperty("DEV_BACKEND_URL")}\""
            )

            manifestPlaceholders["app_name"] = "Sync debug"
            manifestPlaceholders["app_icon"] = "@mipmap/ic_launcher"
            manifestPlaceholders["crashlytics_enabled"] = "false"
            manifestPlaceholders["analytics_enabled"] = "false"
            manifestPlaceholders["perf_enabled"] = "false"
        }

        create("production") {
            dimension = "environment"

            buildConfigField(
                "String",
                "BACKEND_URL",
                "\"${secretProperties.getProperty("PROD_BACKEND_URL")}\""
            )

            manifestPlaceholders["app_name"] = "Sync"
            manifestPlaceholders["app_icon"] = "@mipmap/ic_launcher"
            manifestPlaceholders["crashlytics_enabled"] = "true"
            manifestPlaceholders["analytics_enabled"] = "true"
            manifestPlaceholders["perf_enabled"] = "true"
        }
    }

    lint {
        checkReleaseBuilds = true
        abortOnError = false
        checkDependencies = true
        disable += listOf("MissingTranslation", "ExtraTranslation")
        enable += listOf("UnusedResources", "UnusedIds", "IconDensities")
        warningsAsErrors = false
        htmlReport = true
        xmlReport = true
        checkGeneratedSources = false
        ignoreTestSources = true

        fatal += listOf("InvalidPackage", "HardcodedText", "IconMissingDensityFolder")
        warning += listOf("ContentDescription", "RtlHardcoded", "RtlSymmetry")
    }

    // Build Types Configuration
    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules-debug.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }

        release {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            isJniDebuggable = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            signingConfig = signingConfigs.getByName("debug") // Replace with actual signing config
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.valueOf("VERSION_${libs.versions.jvmTarget.get()}")
        targetCompatibility = JavaVersion.valueOf("VERSION_${libs.versions.jvmTarget.get()}")
    }

    buildFeatures {
        compose = true
        buildConfig = true
        viewBinding = false
    }

    packaging {
        resources {
            excludes += setOf(
                "/META-INF/{AL2.0,LGPL2.1}",
                "/META-INF/LICENSE",
                "/META-INF/LICENSE.txt",
                "/META-INF/NOTICE",
                "/META-INF/NOTICE.txt",
                "/META-INF/ASL2.0",
                "/META-INF/DEPENDENCIES",
                "/META-INF/INDEX.LIST"
            )
        }

        jniLibs {
            useLegacyPackaging = false
        }
    }
}

// Kotlin Configuration
kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.fromTarget(libs.versions.jvmTarget.get()))

        freeCompilerArgs.addAll(
            "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api",
            "-opt-in=androidx.compose.foundation.ExperimentalFoundationApi",
            "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
            "-opt-in=kotlinx.coroutines.FlowPreview"
        )
    }
}

// Room Configuration
room {
    schemaDirectory("$projectDir/schemas")
}

dependencies {

    fun prodImplementation(dependencyNotation: Any) {
        add("productionImplementation", dependencyNotation)
    }

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

    // Firebase dependencies - only for production flavor
    prodImplementation(platform(libs.firebase.bom))
    prodImplementation(libs.firebase.analytics)
    prodImplementation(libs.firebase.crashlytics)
    prodImplementation(libs.firebase.performance)

    ksp(libs.hilt.compiler)
    ksp(libs.hilt.ext.compiler)
    ksp(libs.room.compiler)
}