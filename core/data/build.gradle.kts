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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    // Kotlin Coroutine
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}")
    // Retrofit
    api("com.squareup.retrofit2:retrofit:${Versions.retrofit}")
    api("com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}")
    api("com.squareup.retrofit2:converter-moshi:${Versions.moshiRetrofitConverter}")
    api("com.github.skydoves:sandwich:${Versions.sandwich}")
    // Moshi
    api("com.squareup.moshi:moshi-kotlin:${Versions.moshiKotlin}")
    api("com.squareup.moshi:moshi-kotlin-codegen:${Versions.codeGen}")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:${Versions.codeGen}")

    // Koin AndroidX (Dependency Injection)
    implementation("org.koin:koin-androidx-scope:${Versions.koin}")
    implementation("org.koin:koin-androidx-viewmodel:${Versions.koin}")
    implementation("org.koin:koin-androidx-ext:${Versions.koin}")

    testImplementation("junit:junit:4.13.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}