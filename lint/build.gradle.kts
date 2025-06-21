import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `java-library`
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.android.lint)
}

java {
    sourceCompatibility = JavaVersion.valueOf("VERSION_${libs.versions.jvmTarget.get()}")
    targetCompatibility = JavaVersion.valueOf("VERSION_${libs.versions.jvmTarget.get()}")
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.fromTarget(libs.versions.jvmTarget.get()))
    }
}

lint {
    htmlReport = true
    htmlOutput = file("lint-report.html")
    textReport = true
    absolutePaths = false
    ignoreTestSources = true
}

dependencies {
    compileOnly(libs.lint.api)
    compileOnly(libs.lint.checks)
}