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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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
    implementation(cLibs.annotation)
    implementation(cLibs.constraintlayout)
    implementation(cLibs.recyclerview)
    implementation(cLibs.bundles.room)


    implementation(cLibs.material)
    implementation(cLibs.brv)
    implementation(cLibs.jodatime)
    implementation(cLibs.therouter)
    implementation(cLibs.androidautosize)
    implementation(cLibs.basePopup)
    implementation(cLibs.toast)
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

    val composeBom = platform("androidx.compose:compose-bom:2023.05.01")
    api(composeBom)
    androidTestApi(composeBom)
    api("androidx.compose.material3", "material3")
    api("androidx.compose.ui", "ui")
    api("androidx.compose.ui", "ui-tooling-preview")
    debugApi("androidx.compose.ui", "ui-tooling")

    api(cLibs.accompanist.systemuicontroller)
    api(cLibs.bundles.compose.library)
}