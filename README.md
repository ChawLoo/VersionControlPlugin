@[TOC](如何使用Gradle7.0+的VERSION_CATALOG)
>把重要补充放在前面（2022年6月17日）：该功能测试下来发现，需要把**gradle**文件夹下的`gradle-wrapper.properties`中，gradle版本改为`7.4.2`以上才可以，否则无法解析
# 前言

由于本人喜欢用新技术，也喜欢研究新技术，前阵子Gradle升级至7.2.1后，在研究更新后改了什么，怀着好奇心，打开了[Gradle官方文档](https://docs.gradle.org)，随便看看发现了一个依赖统一管理的全新方式-VERSION_CATALOG，喜欢捣鼓的我，开始研究如何使用。

# 查看官网文档

首先我在官方文档看了一下，然后CSDN等常用的技术文章论坛搜了一下，几乎是清一色的官方文档直译，偶尔带点小推荐，我当时的表情是：
![黑人问号](https://img-blog.csdnimg.cn/5032becb09ad4ce48eaba1633f155e98.jpeg#pic_center)
那我为何不这样：
![在这里插入图片描述](https://img-blog.csdnimg.cn/69a810b66b124d8a84abc058cccf7ea4.png)
不满足于此的我，着手自己研究，官方文档也是截取了部分代码，有些看起来还是云里雾里的。

基于官方文档，我结合自身项目写了这篇文章，给自己存点干活，好了废话不多说，上干货。

# 干货部分
[官网文档地址](https://docs.gradle.org/current/userguide/platforms.html)先给大佬奉上，基本上父类目下的都有用，可以先看一下官方文档，学习一下。
有言在先，Catalog目前处于预览版本，需要手动开启。另外，我已经把grardle文件从groovy迁移至了kts，可以看[官方文档](https://docs.gradle.org/current/userguide/migrating_from_groovy_to_kotlin_dsl.html)进行迁移，或者搜一下相关文章还是很多的，我在这里就不多说了。
## 开启功能
1. 在项目根目录找到【settings.gradle.kts】文件，开启VERSION_CATALOG

```kotlin
	enableFeaturePreview("VERSION_CATALOGS")
```

2. 这个时候我们可以同样在settings.gradle.kts，加入下面这段代码

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    //注意，重点在这里
    versionCatalogs {
        create("lib") {
            library("core-ktx", "androidx.core", "core-ktx").version("1.7.0")
            library("appcompat", "androidx.appcompat", "appcompat").version("1.4.1")
        }
    }
}
```
其中，create中的lib为创建的目录名，可以自己定义，

## 简单使用
第一种，有点类似平时依赖的那样
```kotlin
	//入参是别名和完整的依赖和版本号，比如上面的appcompat可以写成：
	versionCatalogs {
        create("lib") {
            library("appcompat","androidx.appcompat:appcompat:1.4.1")
        }
    }
	
```
第二种，
```kotlin
	//入参为{别名},{group},{artifact}
	versionCatalogs {
		create("lib") {
			library("core-ktx", "androidx.core", "core-ktx").version("1.7.0")
		}
	}
```
然后就可以在每一个module里面的build.gradle.kts中使用依赖，比如我自己项目的module-base
```kotlin
dependencies {
	api(lib.core.ktx)
    api(lib.appcompat)
}
```
当然，你可以创建多个目录，比如，你可以把androidx的内容单独放置，
```kotlin
//settings.gradle.kts
	versionCatalogs {
		crete("lib"){
	        library("fastjson", "com.alibaba", "fastjson").version("1.2.79")
	        library("fastjson2", "com.alibaba.fastjson2", "fastjson2").version("2.0.4")
	        library("fastjson2-kotlin", "com.alibaba.fastjson2", "fastjson2-kotlin").version("2.0.4")
		}
		
		create("androidx"){
			library("core-ktx", "androidx.core", "core-ktx").version("1.7.0")
			library("appcompat", "androidx.appcompat", "appcompat").version("1.4.1")
			library("activity-ktx", "androidx.activity", "activity-ktx").version("1.4.0")
			library("fragment-ktx", "androidx.fragment", "fragment-ktx").version("1.4.1")
		}
	}
```
>注意：我尝试过AndroidX，发现没有生成对应的，所以名称有可能必须小写，这个可以自己尝试一下

引入就可以采用新方式了
```kotlin
//任何module下的 build.gradle.kts
dependencies{
	api(androidx.core.ktx)
	api(lib.fastjson2.kotlin)
}
```
有言在后，必定重要，官方对alias命名有一套规则，详细如下（纯翻译）：
别名必须由一系列标识符组成，由破折号 ( -, 推荐)、下划线 ( _) 或点 ( .) 分隔。标识符本身必须由 ascii 字符组成，最好是小写，最后是数字。
例如：

- `appcompat`是一个有效的别名
- `core.kts`是一个有效的别名
- `fastjson2-kotlin`是一个有效的别名
- `androidx.fragment.kts`也是一个有效的别名
- 但`this.#is.not!`

然后为每个子组生成别名会创建成类型安全访问器。例如，给定名为 的版本目录中的以下别名libs：
`appcompat`,`core-ktx`,`activity-kts`,`androidx.fragment.kts`
将会自动生成一下类型安全的访问器：
- `lib.appcompat`
- `lib.core.kts`
- `lib.activity.kts`
- `lib.androidx.fragment.kts`

前缀lib来自版本目录名称。

如果您想避免生成子组访问器，我们建议依靠大小写来区分。例如，别名`activityKts`,`coreKtx`和`fastjson2Kotlin`将分别映射到`libs.groovyCore`,`libs.groovyJson`和`libs.groovyXml`访问器。

至此，简单的依赖引入我们就完成了。
## 具有相同版本号的依赖
当我们遇到部分依赖具有相同版本号时，我个人认为还得加一个判断是，来源相同，比如我用的coil图片加载框架，那其中会涉及到两个依赖：`io.coil-kt.coil`和`io.coil.kt.coil-gif`，并且他们的版本号一致，则可以采用如下方式：
```kotlin
        version("coil", "2.1.0")
        library("coil", "io.coil-kt", "coil").versionRef("coil")
        library("coil-gif", "io.coil-kt", "coil-gif").versionRef("coil")
        //包括使用kotlin开发语言的工程师，如下两个也是常备的依赖
		version("kotlin", "1.7.0")
        library("stdlib", "org.jetbrains.kotlin", "kotlin-stdlib").versionRef("kotlin")
        library("reflect", "org.jetbrains.kotlin", "kotlin-reflect").versionRef("kotlin")
```
单独申明的version也可以通过类型安全的访问器获得，比如minSdk，就可以全局统一管理最低适配版本等
```kotlin
	#settings.gradle.kts
	version("minSdk","24")
	version("targetSdk","31")
	
	#build.gradle.kts(:app)
	android {
		defaultConfig {
			minSdk = libs.versions.minSdk.get().toInt()
			targetSdk = libs.versions.targetSdk.get().toInt()
			...
		}
	}
```
## 包的概念
使用kotlin语言作为开发语言的都有这样的情况：
```kotlin
val kotlinVer = "1.7.0"
val coroutineVer = "1.6.2"
dependencies{
	api(kotlin("stdlib", version = kotlinVer))
    api(kotlin("reflect", version = kotlinVer))
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutineVer}")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:${coroutineVer}")
}
```
kt和协程依赖的一大堆，还有第三方比如友盟，像我的一个项目依赖了21个跟友盟相关的包。如果你用了VERSION_CATALOG，就可以这样写：
```kotlin
dependencies{
	api(lib.bundles.kotlin)
    api(lib.bundles.coroutines)
    //所有module只需要这一句就能依赖所有
    api(lib.bundles.umeng)
}
```
是不是简洁了很多，这就是它的bundle包机制，那么怎么写呢？我们回到`settings.gradle.kts`，在加入依赖后，在下面同时加入`bundle`，方法需要两个参数，`alias(别名)`,`List<String>(子依赖的别名集合)`
```kotlin
    versionCatalog {
        version("kotlin", "1.7.0")
        library("stdlib", "org.jetbrains.kotlin", "kotlin-stdlib").versionRef("kotlin")
        library("reflect", "org.jetbrains.kotlin", "kotlin-reflect").versionRef("kotlin")
        //bundle的入参分别为，alias（别名），需要依赖的别名集合
        bundle("kotlin", listOf("stdlib", "reflect"))
        
        bundle(
                "umsdk", listOf(
                    "umsdk-common",
                    "umsdk-asms",
                    ...
                    "umsdk-huawei-push",
                    "umsdk-huawei-umengaccs",
                    "umsdk-vivo-push",
                    "umsdk-vivo-umengaccs",
                    "umsdk-oppo-push",
                    "umsdk-oppo-umengaccs",
                )
        )
        //21个依赖就不放出来了
}
```
这就是bundle的写法，官方给了bundle的概念，让依赖版本统一的管理更加的简洁易懂。

>tips:不同类型的别名是可以重复的，他们之间相互独立。
允许以下方式使用：
> - `version("kotlin","")`,
> - `library("kotlin","")`,
> - `bundle("kotlin",listOf("",""))`

## 你以为它只能管理库吗？不！还有插件！
没错，除了库，VERSION_CATALOG还支持声明插件版本，唯一区别是，库由他们的`group`、`artifact`和`version`标识，而Gradle插件仅只有他们的`id`和`version`标识。因此，他们需要额外声明，不能用`library`，对此，官方提供了`plugin`方法，如下：
```kotlin
    dependencyResolutionManagement {
        versionCatalogs {
            create("libs") {
            	version("ksp", "1.7.0-1.0.6")
                plugin("ksp", "com.google.devtools.ksp").versionRef("ksp")
				
				version("kotlin", "1.7.0")
            	library("stdlib", "org.jetbrains.kotlin", "kotlin-stdlib").versionRef("kotlin")
            	library("reflect", "org.jetbrains.kotlin", "kotlin-reflect").versionRef("kotlin")
            	bundle("kotlin", listOf("stdlib", "reflect"))
                plugin("kotlin-parcelize", "org.jetbrains.kotlin.plugin.parcelize").versionRef("kotlin")
            	plugin("kotlin-serialization", "org.jetbrains.kotlin.plugin.serialization").versionRef("kotlin")
            }
        }
    }
```
使用方式：
```kotlin
#build.gradle.kts(:app)
plugins{
	...
	alias(libs.plugins.ksp)
}
ksp{
    
}
```
而且有没有发现，还能跟库的依赖版本保持一致的情况下可以共同，有没有很nice的感觉？
![在这里插入图片描述](https://img-blog.csdnimg.cn/4d5521ba059e4b26b5cc04b7502e4f4c.gif#pic_center)
但是现实是有可能会出现如下情况：
![在这里插入图片描述](https://img-blog.csdnimg.cn/f16bda6bb770418d8b578705a486e342.png)
原因未知：解决方案尝试更换Gradle版本，更换JDK，清理缓存，重启电脑。。。。。无效，但是第一次使用的时候并没有出现这个问题，所以有待深入研究，毕竟AS时不时就会抽风找不到文件，不过不重要，依然能用，就是这个爆红让我强迫症犯了，所以一般我不用，所以还是~~删了删了~~ ，了解了就行，毕竟kts还没研究透。

## TOML文件格式
Gradle的VERSION_CATALOG提供了一个TOML文件来声明一个目录，TOML文件由4个主要部分组成：

 - 该[versions]部分用于声明可以被依赖项引用的版本
 - 该[libraries]部分用于声明坐标的别名
 - 该[bundles]部分用于声明依赖包、
 - 该[plugins]部分用于声明插件

例如：
```yma
[versions]
coil = "2.1.0"
kotlin = "1.7.0"

[libraries]
activity-ktx = {group = "androidx.activity", name = "activity-ktx", version = "1.4.0" }
reflect = {group = "org.jetbrains.kotlin", name = "kotlin-reflect", version.ref = "kotlin" }

[bundles]
coil = ["coil", "coil-gif"]
coroutines = ["kotlinx-coroutines-core", "kotlinx-coroutines-android"]
```
看一下基本上就学会怎么写了，编写了TOML文件就可以通过TOML文件进行多个项目进行共享，别着急写，看完文章再写不迟。
## 共享目录
>版本目录在单个构建（可能是多项目构建）中使用，但也可以在构建之间共享。例如，一个组织可能想要创建来自不同团队的不同项目可能使用的依赖关系目录。
### 从TOML文件导入目录
>版本目录构建器 API支持包含来自外部文件的模型。如果需要，这使得重用主构建的目录成为可能`buildSrc`。例如，该`buildSrc/settings.gradle(.kts)`文件可以使用以下方法包含此文件：
```kotlin
dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}
```
### 插件
虽然本地TOML文件导入方式很方便，但是现在都是自动集成的时代，另外手动去写TOML文件又累又麻烦，程序员都是一个千方百计找偷懒方法的生物，Gradle给我们提供了两个插件`version-catalog`和用于发布的`maven-publish`。
我们先引入：
```kotlin
#build.gradle.kts(:project)
plugins {
    `version-catalog`
    `maven-publish`
}
```
然后应用插件并声明目录中的依赖和插件，我就是在这里思考了一下，官方案例就很奇怪，没有说上下文，让人很迷惑
```kotlin
//先看官方的
catalog {
    // declare the aliases, bundles and versions in this block
    versionCatalog {
        library("my-lib", "com.mycompany:mylib:1.2")
    }
}

//在看我的
catalog {
    // declare the aliases, bundles and versions in this block
    versionCatalog {
        version("coroutines", "1.6.2")
        library("kotlinx-coroutines-core", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").versionRef("coroutines")
        library("kotlinx-coroutines-android", "org.jetbrains.kotlinx", "kotlinx-coroutines-android").versionRef("coroutines")
        bundle("coroutines", listOf("kotlinx-coroutines-core", "kotlinx-coroutines-android"))
    }
}
```
实际上，这个插件是用于自动生成TOML文件的，所以内部的依赖就是你项目所需的依赖，等同于settings.gradle.kts中声明的那些，下一步打开Android Studio的右侧边栏的Gradle，找到位于`【Tasks】` → `【build】` → `【generateCatalogAsToml】`，双击运行
![在这里插入图片描述](https://img-blog.csdnimg.cn/e1275920c14d4b86b55c10c3a0c02a23.png)
执行完Tasks后会在对应的module中的build目录下生成一个文件夹`version-catalog`，本人写在project下的build.gradle.kts，所以自动生成的目录在项目根目录的build文件夹下：
![在这里插入图片描述](https://img-blog.csdnimg.cn/af0b46220b554dccab862c9a9030fafd.png)

有个文件名为`libs.versions.toml`文件，文件名为默认的，官方也有更改文件名的API，我觉得没必要，然后可以通过应用`maven-publish`插件并将发布配置为使用该versionCatalog组件来发布这样的目录。
mavenCentral发布流程我就不在这里说了，需要的话搜一下还是有很多文章的。
上传至MavenCentral后，回到settings.gradle.kts，将原有的依赖等改为：
```kotlin
versionCatalogs {
	create("lib") {
		from("你的groupId:你的artifactId:你的版本")
		//当然这里依然可以补充别的依赖
	}
}
```
>tips:依赖以后就可以吧原先的注释掉了，留着是方便下次生成TOML和上传maven，另外，maven-publish的发布自动会执行generateCatalogAsToml，一步到位。

好了，干货就大概这些，也是选取了一些比较常用的和结合了自身项目写的文章，写作次数不多，将就看看吧，有问题有想法大家一起讨论。
最后附上我自己的版本控制库，仅供参考：[VersionControlPlugin](https://github.com/ChawLoo/VersionControlPlugin)
