@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(cLibs.plugins.android.application) apply false
    alias(cLibs.plugins.android.library) apply false
    kotlin("android") version cLibs.versions.kotlin.get() apply false
    alias(cLibs.plugins.kotlin.serialization)
    alias(cLibs.plugins.ksp) apply false
    alias(cLibs.plugins.therouter) apply false
}
task<Delete>("clean") {
    group = "build"
    delete(rootProject.buildDir)
}