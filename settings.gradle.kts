pluginManagement {
    repositories {
        gradlePluginPortal()
        maven(url = "https://jitpack.io")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
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
    repositories {
        google()
        mavenCentral()
        maven {
            isAllowInsecureProtocol = true
            url = uri("https://packages.aliyun.com/maven/repository/2414883-release-tOPoja/")
            credentials {
                username = localUserName
                password = localPwd
            }
        }
        maven(url = "https://jitpack.io")
    }
    versionCatalogs {
        create("cLibs") {
            from(files("VersionControlPlugin/build/version-catalog/libs.versions.toml"))
        }
    }
}
rootProject.name = "VersionControlPlugin"
include(":app")
include(":VersionControlPlugin")
