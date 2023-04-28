pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven(url = "https://maven.aliyun.com/repository/central")
        maven(url = "https://maven.aliyun.com/repository/public")
        maven(url = "https://maven.aliyun.com/repository/google")
        maven(url = "https://maven.aliyun.com/repository/gradle-plugin")
        maven(url = "https://jitpack.io")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://maven.aliyun.com/repository/central")
        maven(url = "https://maven.aliyun.com/repository/public")
        maven(url = "https://maven.aliyun.com/repository/google")
        maven(url = "https://maven.aliyun.com/repository/gradle-plugin")
        maven(url = "https://jitpack.io")
    }
    versionCatalogs {
        create("cLibs") {
            from("io.github.chawloo:VersionControlPlugin:1.1.15")

            version("accompanistVer", "0.28.0")
            library("accompanist-navigation-animation", "com.google.accompanist", "accompanist-navigation-animation").versionRef("accompanistVer")
            library("accompanist-systemuicontroller", "com.google.accompanist", "accompanist-systemuicontroller").versionRef("accompanistVer")
            library("accompanist-pager", "com.google.accompanist", "accompanist-pager").versionRef("accompanistVer")
            bundle("accompanist", listOf("accompanist-navigation-animation", "accompanist-systemuicontroller", "accompanist-pager"))

            library("constraintlayout-compose", "androidx.constraintlayout", "constraintlayout-compose").version("1.0.1")
            version("navVer", "2.5.3")
            library("navigation-compose", "androidx.navigation", "navigation-compose").versionRef("navVer")
            library("compose-coil", "io.coil-kt", "coil-compose").version("2.2.2")
            bundle("compose-library", listOf("constraintlayout-compose", "navigation-compose", "compose-coil"))
        }
    }
}
rootProject.name = "VersionControlPlugin"
include(":app")
include(":VersionControlPlugin")
