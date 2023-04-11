plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "cn.chawloo.versioncontrolplugin.example"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    implementation(cLibs.bundles.kotlin)
    implementation(cLibs.bundles.coroutines)
    implementation(cLibs.kotlinx.serialization.json)

    implementation(cLibs.core.ktx)
    implementation(cLibs.appcompat)
    implementation(cLibs.multidex)
    implementation(cLibs.activity.ktx)
    implementation(cLibs.fragment.ktx)
    implementation(cLibs.viewmodel)
    implementation(cLibs.livedata)
    implementation(cLibs.annotation)
    implementation(cLibs.constraintlayout)
    implementation(cLibs.recyclerview)
    implementation(cLibs.startup.runtime)
    implementation(cLibs.bundles.room)


    implementation(cLibs.material)
    implementation(cLibs.brv)
    implementation(cLibs.jodatime)
    implementation(cLibs.arouter.api)
    implementation(cLibs.androidautosize)
    implementation(cLibs.basePopup)
    implementation(cLibs.toast)
    implementation(cLibs.koin.android)
    implementation(cLibs.okhttp)
    implementation(cLibs.retrofit)
    implementation(cLibs.xPermission)
    implementation(cLibs.mmkv)
    implementation(cLibs.viewbinding.ktx)
    implementation(cLibs.jodatime)
    implementation(cLibs.wechat.sdk.android.without.mta)
    implementation(cLibs.wheelView)
    implementation(cLibs.x5webview)
    implementation(cLibs.banner)

    implementation(cLibs.bundles.coil)
    implementation(cLibs.bundles.saf.log)
    implementation(cLibs.bundles.immersionbar)

    testImplementation(cLibs.junit)
}