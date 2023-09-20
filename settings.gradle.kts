pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven {
            url = uri("https://packages.aliyun.com/maven/repository/2418478-release-GhmPUt/")
            credentials {
                username = "609399173a10edbf367f5264"
                password = "=RTs0bvMruGT"
            }
        }
        google()
        maven(url = "https://jitpack.io")
    }
    versionCatalogs {
        create("cLibs") {
            from("io.github.chawloo:VersionControlPlugin:1.3.1")
        }
    }
}
rootProject.name = "VersionControlPlugin"
include(":app")
include(":VersionControlPlugin")
