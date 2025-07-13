import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidLintConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                // For JVM projects, use compileOnly instead of lintChecks
                add("compileOnly", libs.findLibrary("lint.api").get())
                add("compileOnly", libs.findLibrary("lint.checks").get())
            }
        }
    }
}