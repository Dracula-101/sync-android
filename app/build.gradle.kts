import org.jetbrains.kotlin.konan.properties.loadProperties

plugins {
    alias(libs.plugins.sync.android.application)
    alias(libs.plugins.sync.android.application.compose)
    alias(libs.plugins.sync.android.application.flavors)
    alias(libs.plugins.sync.android.application.firebase)
    alias(libs.plugins.sync.android.hilt)
    alias(libs.plugins.sync.android.room)
}

val secretPropertiesFile = rootProject.file("secrets.properties")
val secretProperties = if (secretPropertiesFile.exists()) {
    loadProperties(secretPropertiesFile.path)
} else {
    throw IllegalStateException("Secret properties file not found: ${secretPropertiesFile.path}")
}

val keyPropertiesFile = rootProject.file("key.properties")
val keyProperties = loadProperties(keyPropertiesFile.path)

android {
    namespace = "com.application.sync"

    signingConfigs {
        getByName("debug") {
            storeFile = file("../keystores/debug-keystore.jks")
            storePassword = "DebugSync"
            keyAlias = "debug-sync"
            keyPassword = "debug-sync"
        }

        create("release") {
            storeFile = file(keyProperties.getProperty("KEYSTORE_FILE"))
            storePassword = keyProperties.getProperty("KEYSTORE_PASSWORD")
            keyAlias = keyProperties.getProperty("KEY_ALIAS")
            keyPassword = keyProperties.getProperty("KEY_PASSWORD")
        }
    }

    buildTypes {
        debug {
            signingConfig = signingConfigs.getByName("debug")
        }

        release {
            signingConfig = signingConfigs.getByName("release")
        }
    }
}

dependencies {

    implementation(projects.core.network)
    implementation(projects.core.analytics)
    implementation(projects.ui.design)
    implementation(projects.ui.components)

    implementation(libs.androidx.core.splashscreen)
    implementation(libs.accompanist.permissions)
    implementation(libs.androidx.dataStore)
    implementation(libs.androidx.core.security.crypto)
    implementation(libs.androidx.work.ktx)
    implementation(libs.hilt.ext.work)
    implementation(libs.kotlinx.datetime)

    ksp(libs.hilt.ext.compiler)
}