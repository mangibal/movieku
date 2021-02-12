plugins {
    id("com.android.dynamic-feature")
    kotlin("android")
    id("kotlin-parcelize")
    kotlin("kapt")
//    id("kotlin-android")
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
//    packagingOptions {
//        exclude("META-INF/metadata.kotlin_module")
//    }
}

dependencies {
    implementation(project(Modules.APP))
    implementation(project(Modules.CORE))
    implementation(project(Modules.DATA))
    implementation(project(Modules.DOMAIN))

    testImplementation("junit:junit:4.13.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
    androidTestImplementation("androidx.annotation:annotation:1.1.0")
}