import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("com.android.library")
    kotlin("android")
    `version-catalog`
    `maven-publish`
    signing
}
catalog {
    versionCatalog {
        version("minSdk", "26")
        version("targetSdk", "33")
        version("compileSdk", "33")
        version("buildToolsVersion", "31.0.0")
        version("compileSdkPreview", "UpsideDownCake")

        version("kotlin", "1.8.22")
        plugin("kotlin-android", "org.jetbrains.kotlin.android").versionRef("kotlin")
        plugin("kotlin-kapt", "org.jetbrains.kotlin.kapt").versionRef("kotlin")
        plugin("kotlin-parcelize", "org.jetbrains.kotlin.plugin.parcelize").versionRef("kotlin")
        plugin("kotlin-serialization", "org.jetbrains.kotlin.plugin.serialization").versionRef("kotlin")

        library("stdlib-jdk7", "org.jetbrains.kotlin", "kotlin-stdlib-jdk7").versionRef("kotlin")
        library("stdlib-jdk8", "org.jetbrains.kotlin", "kotlin-stdlib-jdk8").versionRef("kotlin")
        library("reflect", "org.jetbrains.kotlin", "kotlin-reflect").versionRef("kotlin")
        bundle(
            "kotlin", listOf(
                "stdlib-jdk7",
                "stdlib-jdk8",
                "reflect"
            )
        )

        version("coroutines", "1.7.2")
        library("kotlinx-coroutines-core", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").versionRef("coroutines")
        library("kotlinx-coroutines-android", "org.jetbrains.kotlinx", "kotlinx-coroutines-android").versionRef("coroutines")
        bundle("coroutines", listOf("kotlinx-coroutines-core", "kotlinx-coroutines-android"))

        library("core-ktx", "androidx.core", "core-ktx").version("1.10.1")
        library("appcompat", "androidx.appcompat", "appcompat").version("1.6.1")
        library("multidex", "androidx.multidex", "multidex").version("2.0.1")
        library("activity-ktx", "androidx.activity", "activity-ktx").version("1.7.2")
        library("fragment-ktx", "androidx.fragment", "fragment-ktx").version("1.5.7")
        library("annotation", "androidx.annotation", "annotation").version("1.6.0")
        library("constraintlayout", "androidx.constraintlayout", "constraintlayout").version("2.1.4")
        library("recyclerview", "androidx.recyclerview", "recyclerview").version("1.2.1")
        library("startup-runtime", "androidx.startup", "startup-runtime").version("1.1.1")
        library("splashscreen", "androidx.core", "core-splashscreen").version("1.0.1")

        version("lifecycle", "2.6.1")
        library("lifecycle-viewmodel", "androidx.lifecycle", "lifecycle-viewmodel-ktx").versionRef("lifecycle")
        library("lifecycle-livedata", "androidx.lifecycle", "lifecycle-livedata-ktx").versionRef("lifecycle")

        bundle(
            "androidx", listOf(
                "core-ktx",
                "appcompat",
                "multidex",
                "activity-ktx",
                "fragment-ktx",
                "constraintlayout",
                "recyclerview",
                "startup-runtime",
                "splashscreen",
                "lifecycle-viewmodel",
                "lifecycle-livedata",
            )
        )



        version("room", "2.5.2")
        library("room-runtime", "androidx.room", "room-runtime").versionRef("room")
        library("room-ktx", "androidx.room", "room-ktx").versionRef("room")
        library("room-compiler", "androidx.room", "room-compiler").versionRef("room")
        bundle("room", listOf("room-runtime", "room-ktx"))

        library("androidautosize", "me.jessyan", "autosize").version("1.2.1")
        library("material", "com.google.android.material", "material").version("1.5.0-alpha04")
        library("retrofit", "com.squareup.retrofit2", "retrofit").version("2.9.0")
        library("okhttp", "com.squareup.okhttp3", "okhttp").version("4.11.0")
        library("net", "com.github.liangjingkanji", "Net").version("3.5.8")
        library("brv", "com.github.liangjingkanji", "BRV").version("1.4.1")

        version("chucker", "4.0.0")
        library("chucker", "com.github.chuckerteam.chucker", "library").versionRef("chucker")
        library("chucker-no-op", "com.github.chuckerteam.chucker", "library").versionRef("chucker")

        library("brvah", "com.github.CymChad", "BaseRecyclerViewAdapterHelper").version("3.0.11")
        library("kotlinx-serialization-json", "org.jetbrains.kotlinx", "kotlinx-serialization-json").version("1.5.1")
        library("fastjson", "com.alibaba", "fastjson").version("1.2.79")
        library("jodatime", "joda-time", "joda-time").version("2.12.5")
        library("crashReport", "com.tencent.bugly", "crashreport").version("4.1.9.2")
        library("basePopup", "io.github.razerdp", "BasePopup").version("3.2.1")
        library("mmkv", "com.tencent", "mmkv-static").version("1.3.0")
        library("xPermission", "com.github.getActivity", "XXPermissions").version("18.2")
        library("wheelView", "com.github.zyyoona7.WheelPicker", "wheelview").version("2.0.7")
        library("toast", "com.github.getActivity", "Toaster").version("12.3")
        library("viewbinding-ktx-old", "com.github.DylanCaiCoding.ViewBindingKTX", "viewbinding-ktx").version("1.2.2")
        library("viewbinding-ktx", "com.github.DylanCaiCoding.ViewBindingKTX", "viewbinding-ktx").version("2.1.0")
        library("banner", "io.github.youth5201314", "banner").version("2.2.2")
        library("flexbox", "com.google.android.flexbox", "flexbox").version("3.0.0")

        version("therouter", "1.2.0-beta3")
        library("therouter", "cn.therouter", "router").versionRef("therouter")
        library("therouter-apt", "cn.therouter", "apt").versionRef("therouter")
        plugin("therouter", "cn.therouter").versionRef("therouter")

        library("immersionbar", "com.geyifeng.immersionbar", "immersionbar").version("3.2.2")
        library("immersionbar-ktx", "com.geyifeng.immersionbar", "immersionbar-ktx").version("3.2.2")
        bundle("immersionbar", listOf("immersionbar", "immersionbar-ktx"))

        version("pictureSelector", "v3.11.1")
        library("pictureSelector", "io.github.lucksiege", "pictureselector").versionRef("pictureSelector")
        library("pictureSelector-compress", "io.github.lucksiege", "compress").versionRef("pictureSelector")
        library("pictureSelector-ucrop", "io.github.lucksiege", "ucrop").versionRef("pictureSelector")
        library("pictureSelector-camerax", "io.github.lucksiege", "camerax").versionRef("pictureSelector")
        bundle(
            "pictureSelector", listOf(
                "pictureSelector",
                "pictureSelector-compress",
                "pictureSelector-ucrop",
                "pictureSelector-camerax"
            )
        )

        version("saf-log", "2.6.9")
        library("saf-log-core", "com.github.fengzhizi715.SAF-Kotlin-log", "core").versionRef("saf-log")
        library("saf-log-okhttp", "com.github.fengzhizi715", "saf-logginginterceptor").version("v1.6.13")
        bundle("saf-log", listOf("saf-log-core", "saf-log-okhttp"))


        library("x5webview", "com.tencent.tbs", "tbssdk").version("44286")
        library("wechat-sdk-android-without-mta", "com.tencent.mm.opensdk", "wechat-sdk-android-without-mta").version("6.8.0")

        version("coil", "2.4.0")
        library("coil", "io.coil-kt", "coil").versionRef("coil")
        library("coil-gif", "io.coil-kt", "coil-gif").versionRef("coil")
        library("compose-coil", "io.coil-kt", "coil-compose").versionRef("coil")
        bundle("coil", listOf("coil", "coil-gif"))

        library("accompanist-systemuicontroller", "com.google.accompanist", "accompanist-systemuicontroller").version("0.30.1")

        library("navigation-compose", "androidx.navigation", "navigation-compose").version("2.6.0")
        library("constraintlayout-compose", "androidx.constraintlayout", "constraintlayout-compose").version("1.0.1")
        library("activity-compose", "androidx.activity", "activity-compose").version("1.7.2")
        library("lifecycle-viewmodel-compose", "androidx.lifecycle", "lifecycle-viewmodel-compose").versionRef("lifecycle")

        bundle(
            "compose-library", listOf(
                "constraintlayout-compose",
                "navigation-compose",
                "activity-compose",
                "lifecycle-viewmodel-compose",
                "compose-coil"
            )
        )

        library("junit", "junit", "junit").version("4.13.2")
    }
}
publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "io.github.chawloo"
            artifactId = "VersionControlPlugin"
            version = "1.2.3"
            from(components["versionCatalog"])
            pom {
                name.set("VersionControlPlugin")
                description.set("Libraries VersionControl For Daily Development")
                url.set("https://github.com/ChawLoo/VersionControlPlugin")
                inceptionYear.set("2022")
                scm {
                    url.set("https://github.com/ChawLoo/VersionControlPlugin")
                    connection.set("scm:git:https://github.com/ChawLoo/VersionControlPlugin.git")
                    developerConnection.set("scm:git:https://github.com/ChawLoo/VersionControlPlugin.git")
                }
                licenses {
                    license {
                        name.set("The Apache Software License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("repo")
                        comments.set("A business-friendly OSS license")
                    }
                }
                developers {
                    developer {
                        id.set("ChawLoo")
                        name.set("ChawLoo")
                        email.set("ChawLoo0827@qq.com")
                        url.set("https://github.com/ChawLoo/VersionControlPlugin")
                    }
                }
                issueManagement {
                    system.set("Github")
                    url.set("https://github.com/ChawLoo/VersionControlPlugin")
                }
                withXml {
                    val dependenciesNode = asNode().appendNode("dependencies")
                    project.configurations.all {
                        val name = this.name
                        if (name != "implementation" && name != "compile" && name != "api") {
                            return@all
                        }
                        println(this)
                        dependencies.forEach {
                            println(it)
                            if (it.name == "unspecified") {
                                // 忽略无法识别的
                                return@forEach
                            }
                            val dependencyNode = dependenciesNode.appendNode("dependency")
                            dependencyNode.appendNode("groupId", it.group)
                            dependencyNode.appendNode("artifactId", it.name)
                            dependencyNode.appendNode("version", it.version)
                            if (name == "api" || name == "compile") {
                                dependencyNode.appendNode("scope", "compile")
                            } else { // implementation
                                dependencyNode.appendNode("scope", "runtime")
                            }
                        }
                    }
                }
            }
        }
    }
    val userName = file("../maven.properties").takeIf { it.canRead() }?.run {
        val versionProps = Properties()
        versionProps.load(inputStream())
        versionProps["maven.username"].toString()
    }
    val pwd = file("../maven.properties").takeIf { it.canRead() }?.run {
        val versionProps = Properties()
        versionProps.load(inputStream())
        versionProps["maven.password"].toString()
    }
    repositories {
        maven {
            val releaseRepoUrl = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            val snapshotRepoUrl = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
            url = if (version.toString().endsWith("SNAPSHOT")) {
                snapshotRepoUrl
            } else {
                releaseRepoUrl
            }
            credentials {
                username = userName
                password = pwd
            }
        }
    }
}
signing {
    sign(publishing.publications)
}

android {
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    namespace = "cn.chawloo.versioncontrolplugin"
}

dependencies {
    implementation(cLibs.bundles.androidx)
    testImplementation(cLibs.junit)
}