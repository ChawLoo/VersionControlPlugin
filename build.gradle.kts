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
        classpath("com.android.tools.build:gradle:7.2.1")
        classpath(kotlin("gradle-plugin", version = lib.versions.kotlin.get()))
        classpath(kotlin("serialization", version = lib.versions.kotlin.get()))
        classpath("com.alibaba:arouter-register:1.0.2")
    }
}
task<Delete>("clean") {
    group = "build"
    delete(rootProject.buildDir)
}