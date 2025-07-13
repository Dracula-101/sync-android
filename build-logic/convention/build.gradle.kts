import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.application.sync.build_logic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
    compileOnly(libs.firebase.crashlytics.gradlePlugin)
    compileOnly(libs.firebase.performance.gradlePlugin)
    compileOnly(libs.hilt.gradlePlugin)
    compileOnly(libs.gms.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "sync.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "sync.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplicationFirebase") {
            id = "sync.android.application.firebase"
            implementationClass = "AndroidApplicationFirebaseConventionPlugin"
        }
        register("androidApplicationFlavors") {
            id = "sync.android.application.flavors"
            implementationClass = "AndroidApplicationFlavorsConventionPlugin"
        }
        register("androidLibrary") {
            id = "sync.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "sync.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidRoom") {
            id = "sync.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
        register("androidHilt") {
            id = "sync.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidRetrofit") {
            id = "sync.android.retrofit"
            implementationClass = "AndroidRetrofitConventionPlugin"
        }
        register("androidFeature") {
            id = "sync.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidLint") {
            id = "sync.android.lint"
            implementationClass = "AndroidLintConventionPlugin"
        }
        register("jvmLibrary") {
            id = "sync.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
        register("kotlinAndroid") {
            id = "sync.kotlin.android"
            implementationClass = "KotlinAndroidConventionPlugin"
        }
    }
}