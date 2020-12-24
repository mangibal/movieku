plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-parcelize")
    kotlin("kapt")
}

android {
    compileSdkVersion(Apps.compileSdk)
    buildToolsVersion("30.0.2")

    defaultConfig {
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
//        dataBinding = true
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    api("org.jetbrains.kotlin:kotlin-stdlib:1.4.21")
    api("androidx.core:core-ktx:1.3.2")
    api("androidx.appcompat:appcompat:1.2.0")
    api("com.google.android.material:material:1.2.1")

    // ViewModel
    api("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    api("androidx.lifecycle:lifecycle-reactivestreams-ktx:2.2.0")
    api("androidx.lifecycle:lifecycle-extensions:2.2.0")

    // Koin AndroidX (Dependency Injection)
    api("org.koin:koin-androidx-scope:2.1.6")
    api("org.koin:koin-androidx-viewmodel:2.1.6")
    api("org.koin:koin-androidx-ext:2.1.6")

    testImplementation("junit:junit:4.13.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}