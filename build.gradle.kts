buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven(url = "https://maven.aliyun.com/repository/central")
        maven(url = "https://maven.aliyun.com/repository/public")
        maven(url = "https://maven.aliyun.com/repository/google")
        maven(url = "https://maven.aliyun.com/repository/gradle-plugin")
        maven(url = "https://jitpack.io")
        google()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.1.0-rc01")
        classpath(kotlin("gradle-plugin", version = cLibs.versions.kotlin.get()))
        classpath(kotlin("serialization", version = cLibs.versions.kotlin.get()))
    }
}
task<Delete>("clean") {
    group = "build"
    delete(rootProject.buildDir)
}