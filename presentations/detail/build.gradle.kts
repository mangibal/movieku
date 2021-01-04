plugins {
    id("com.android.dynamic-feature")
    kotlin("android")
    id("kotlin-parcelize")
    kotlin("kapt")
}
android {
    compileSdkVersion(Apps.compileSdk)
    buildToolsVersion("30.0.2")

    defaultConfig {
        applicationId("com.iqbalfauzi.detail")
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        versionCode = Apps.versionCode
        versionName = Apps.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    android.buildFeatures.viewBinding = true

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
//            isShrinkResources = true
//            isZipAlignEnabled = true
//            isJniDebuggable = false
//            isRenderscriptDebuggable = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
//            signingConfig = signingConfigs.getByName("release")
        }
    }
}

dependencies {
    implementation(project(":app"))
    implementation(project(Modules.CORE))

    testImplementation("junit:junit:4.13.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
    androidTestImplementation("androidx.annotation:annotation:1.1.0")
}