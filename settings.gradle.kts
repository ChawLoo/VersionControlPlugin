pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
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
