// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version by extra("1.4.21")
    //    ext.kotlin_version = "1.4.21"
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath("com.android.tools.build:gradle:${Versions.gradle}")
//        dependencies {
//            classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
//        }
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

repositories {
    google()
    jcenter()
    maven { url = uri("https://jitpack.io") }
}
