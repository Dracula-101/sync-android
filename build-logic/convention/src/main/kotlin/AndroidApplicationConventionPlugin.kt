import com.android.build.api.dsl.ApplicationExtension
import com.application.sync.configureAndroid
import com.application.sync.configureApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("sync.android.lint")
            }

            extensions.configure<ApplicationExtension> {
                configureAndroid(this)
                configureApplicationExtension(this)
            }
        }
    }
}