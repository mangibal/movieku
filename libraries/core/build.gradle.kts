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
    api("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    api("androidx.core:core-ktx:${Versions.ktx}")
    api("androidx.appcompat:appcompat:${Versions.appcompat}")
    api("com.google.android.material:material:${Versions.materialDesign}")

    // ViewModel
    api("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}")
    api("androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.viewModel}")
    api("androidx.lifecycle:lifecycle-extensions:${Versions.viewModel}")

    // Koin AndroidX (Dependency Injection)
    api("org.koin:koin-androidx-scope:${Versions.koin}")
    api("org.koin:koin-androidx-viewmodel:${Versions.koin}")
    api("org.koin:koin-androidx-ext:${Versions.koin}")

    testImplementation("junit:junit:4.13.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}