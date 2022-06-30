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
        version("targetSdk", "32")
        version("compileSdk", "32")
        version("kotlin", "1.7.0")
        plugin("kotlin-android", "org.jetbrains.kotlin.android").versionRef("kotlin")
        plugin("kotlin-kapt", "org.jetbrains.kotlin.kapt").versionRef("kotlin")

        library("stdlib", "org.jetbrains.kotlin", "kotlin-stdlib").versionRef("kotlin")
        library("reflect", "org.jetbrains.kotlin", "kotlin-reflect").versionRef("kotlin")
        bundle("kotlin", listOf("stdlib", "reflect"))

        version("coroutines", "1.6.1-native-mt")
        library("kotlinx-coroutines-core", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").versionRef("coroutines")
        library("kotlinx-coroutines-android", "org.jetbrains.kotlinx", "kotlinx-coroutines-android").versionRef("coroutines")
        bundle("coroutines", listOf("kotlinx-coroutines-core", "kotlinx-coroutines-android"))

        library("core-ktx", "androidx.core", "core-ktx").version("1.7.0")
        library("appcompat", "androidx.appcompat", "appcompat").version("1.4.1")
        library("multidex", "androidx.multidex", "multidex").version("2.0.1")
        library("activity-ktx", "androidx.activity", "activity-ktx").version("1.4.0")
        library("fragment-ktx", "androidx.fragment", "fragment-ktx").version("1.4.1")
        library("annotation", "androidx.annotation", "annotation").version("1.3.0")
        library("constraintlayout", "androidx.constraintlayout", "constraintlayout").version("2.1.3")
        library("recyclerview", "androidx.recyclerview", "recyclerview").version("1.2.1")
        library("swiperefreshlayout", "androidx.swiperefreshlayout", "swiperefreshlayout").version("1.1.0")
        library("startup-runtime", "androidx.startup", "startup-runtime").version("1.1.1")

        version("lifecycle", "2.4.1")
        library("viewmodel", "androidx.lifecycle", "lifecycle-viewmodel-ktx").versionRef("lifecycle")
        library("livedata", "androidx.lifecycle", "lifecycle-livedata-ktx").versionRef("lifecycle")

        version("room", "2.5.0-alpha01")
        library("room-runtime", "androidx.room", "room-runtime").versionRef("room")
        library("room-ktx", "androidx.room", "room-ktx").versionRef("room")
        library("room-compiler", "androidx.room", "room-compiler").versionRef("room")
        bundle("room", listOf("room-runtime", "room-ktx"))

        version("koin", "3.2.0")
        library("koin-android", "io.insert-koin", "koin-android").versionRef("koin")

        version("koin_annotations_version", "1.0.0")
        library("koin-compiler", "io.insert-koin", "koin-ksp-compiler").versionRef("koin_annotations_version")
        library("koin-annotations", "io.insert-koin", "koin-annotations").versionRef("koin_annotations_version")

        library("androidautosize", "com.github.JessYanCoding", "AndroidAutoSize").version("v1.2.1")
        library("material", "com.google.android.material", "material").version("1.5.0-alpha04")
        library("fastjson", "com.alibaba", "fastjson").version("1.2.79")
        library("retrofit", "com.squareup.retrofit2", "retrofit").version("2.9.0")
        library("okhttp", "com.squareup.okhttp3", "okhttp").version("5.0.0-alpha.7")
        library("kotlinx-serialization-json", "org.jetbrains.kotlinx", "kotlinx-serialization-json").version("1.3.3")
        library("brv", "com.github.liangjingkanji", "BRV").version("1.3.78")
        library("jodatime", "joda-time", "joda-time").version("2.10.14")
        library("basePopup", "io.github.razerdp", "BasePopup").version("3.2.0")
        library("mmkv", "com.tencent", "mmkv-static").version("1.2.13")
        library("permissionx", "com.guolindev.permissionx", "permissionx").version("1.6.4")
        library("wheelView", "com.github.zyyoona7", "wheelview").version("1.0.9")
        library("toast", "com.github.getActivity", "ToastUtils").version("10.5")
        library("viewbinding-ktx", "com.github.DylanCaiCoding.ViewBindingKTX", "viewbinding-ktx").version("2.0.6")
        library("stateLayout", "com.github.liangjingkanji", "StateLayout").version("1.3.6")


        library("fastjson2", "com.alibaba.fastjson2", "fastjson2").version("2.0.6")
        library("fastjson2-kotlin", "com.alibaba.fastjson2", "fastjson2-kotlin").version("2.0.6")
        library("fastjson2-extension", "com.alibaba.fastjson2", "fastjson2-extension").version("2.0.6")
        bundle("fastjson2", listOf("fastjson2", "fastjson2-kotlin", "fastjson2-extension"))

        version("arouter", "1.5.2")
        library("arouter-compiler", "com.alibaba", "arouter-compiler").versionRef("arouter")
        library("arouter-api", "com.alibaba", "arouter-api").versionRef("arouter")

        library("immersionbar", "com.geyifeng.immersionbar", "immersionbar").version("3.2.2")
        library("immersionbar-ktx", "com.gyf.immersionbar", "immersionbar-ktx").version("3.0.0")
        bundle("immersionbar", listOf("immersionbar", "immersionbar-ktx"))

        version("saf-log", "2.6.7")
        library("saf-log-core", "com.github.fengzhizi715.SAF-Kotlin-log", "core").versionRef("saf-log")
        library("saf-log-fastjson", "com.github.fengzhizi715.SAF-Kotlin-log", "fastjson").versionRef("saf-log")
        library("saf-log-okhttp", "com.github.fengzhizi715.SAF-Kotlin-log", "okhttp").versionRef("saf-log")
        bundle("saf-log", listOf("saf-log-core", "saf-log-fastjson", "saf-log-okhttp"))

        library("x5webview", "com.tencent.tbs", "tbssdk").version("44181")
        library("wechat-sdk-android-without-mta", "com.tencent.mm.opensdk", "wechat-sdk-android-without-mta").version("6.8.0")

        version("coil", "2.1.0")
        library("coil", "io.coil-kt", "coil").versionRef("coil")
        library("coil-gif", "io.coil-kt", "coil-gif").versionRef("coil")
        bundle("coil", listOf("coil", "coil-gif"))

        library("junit", "junit", "junit").version("4.13.2")
    }
}
publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "io.github.chawloo"
            artifactId = "VersionControlPlugin"
            version = "1.0.9"
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
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32
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
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}

