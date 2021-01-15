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
//    packagingOptions {
//        exclude("META-INF/metadata.kotlin_module")
//    }
}

dependencies {
    implementation(project(Modules.DATA))
    api("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    api("org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}")
    api("androidx.core:core-ktx:${Versions.coreKtx}")
    /* UI */
    api("androidx.appcompat:appcompat:${Versions.appcompat}")
    api("com.google.android.material:material:${Versions.materialDesign}")
    api("androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}")
    api("androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}")
//    api("androidx.legacy:legacy-support-v4:1.0.0")
    api("androidx.viewpager2:viewpager2:${Versions.viewPager2}")
    api("de.hdodenhof:circleimageview:${Versions.circleImageView}")
//    api("com.android.support:multidex:${Versions.multidex}")
//    api('androidx.vectordrawable:vectordrawable:1.1.0')
    // Country Code Picker
    // Image Loader
    api("de.hdodenhof:circleimageview:3.1.0")
    api("io.coil-kt:coil:${Versions.coil}")
    api("androidx.browser:browser:${Versions.chromeTab}")
    api("com.google.guava:listenablefuture:9999.0-empty-to-avoid-conflict-with-guava")
    api("ru.tinkoff.scrollingpagerindicator:scrollingpagerindicator:${Versions.pageIndicator}")

    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}")

    // ViewModel
    api("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.viewModel}")
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