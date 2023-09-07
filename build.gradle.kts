buildscript {
    repositories {
        val localUserName = file("maven.properties").takeIf { it.canRead() }?.run {
            val versionProps = java.util.Properties()
            versionProps.load(inputStream())
            versionProps["maven.aliyun.username"].toString()
        }
        val localPwd = file("maven.properties").takeIf { it.canRead() }?.run {
            val versionProps = java.util.Properties()
            versionProps.load(inputStream())
            versionProps["maven.aliyun.password"].toString()
        }
        maven {
            isAllowInsecureProtocol = true
            setUrl("http://47.97.187.94:8536/repository/maven-android/")
            credentials {
                username = localUserName
                password = localPwd
            }
        }
        mavenCentral()
        google()
        maven(url = "https://jitpack.io")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.1.1")
        classpath(kotlin("gradle-plugin", version = cLibs.versions.kotlin.get()))
        classpath(kotlin("serialization", version = cLibs.versions.kotlin.get()))
    }
}
task<Delete>("clean") {
    group = "build"
    delete(rootProject.buildDir)
}