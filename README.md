```
   一个基于Gradle官方提供的API的统一版本依赖库
```

[使用说明](https://blog.csdn.net/qq_24889033/article/details/125307004)

#### Lastest version

module|VersionControlPlugin|Language|License|
---|---|---|---|
version|<img src = "https://maven-badges.herokuapp.com/maven-central/io.github.chawloo/VersionControlPlugin/badge.svg" />|<img src="https://img.shields.io/badge/language-kotlin-orange.svg"/>| [![Hex.pm](https://img.shields.io/hexpm/l/plug.svg)](https://www.apache.org/licenses/LICENSE-2.0)|

## 注意

[官方文档](https://docs.gradle.org/7.3/userguide/platforms.html)

:warning: Central declaration of dependencies is an incubating feature. It requires the activation of the `VERSION_CATALOGS` [feature preview](https://docs.gradle.org/7.3/userguide/feature_lifecycle.html#feature_preview).:warning: 

:warning: 中央依赖声明是一个孵化特性。它需要激活 `VERSION_CATALOGS` [功能预览](https://docs.gradle.org/7.3/userguide/feature_lifecycle.html#feature_preview).:warning: 

## 安装

添加远程仓库根据创建项目的 Gradle 版本有所不同
在Gradle7.6 以前 在项目根目录的 settings.gradle 添加

```groovy
enableFeaturePreview("VERSION_CATALOGS")
```
在Gradle7.6+ 无需开启，默认为开启状态

然后在 项目根目录 的 settings.gradle 添加
```groovy
dependencyResolutionManagement {
    versionCatalogs {
    	libs {
            from("io.github.chawloo:VersionControlPlugin:1.1.12")
        }
    }
}
```
如果采用kts的gradle文件，则如下：
```kotlin
enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from("io.github.chawloo:VersionControlPlugin:1.1.12")
        }
    }
}
```
引入后就可以在module以及app模块中使用对应的依赖kts为例子。
```kotlin

android {
    compileSdk = libs.versions.compileSdk.get().toInt()
    defaultConfig {
        applicationId = "自己的包名"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
    }
}

dependencies {
    api(libs.baseLib)
    kapt(libs.arouter.compiler)
}
```

## 说明

这个库平常自己应用于生产项目，放置了一些公司所有项目的公共依赖，想用可自行fork后增加即可，也可以提issue新增，另外版本也是经常会检查更新，升级为最新版本，如遇到适配问题请自行适配。

## Feature

后续有时间整理一个清单以及更新说明，方便查看

## License

```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
