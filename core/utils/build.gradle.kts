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
//    packagingOptions {
//        exclude("META-INF/metadata.kotlin_module")
//    }
}

dependencies {
//    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version")
//    implementation(project(Modules.APP))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}")

    implementation("androidx.appcompat:appcompat:${Versions.appcompat}")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}")
    implementation("io.coil-kt:coil:${Versions.coil}")
    implementation("androidx.core:core-ktx:${Versions.coreKtx}")
    implementation("androidx.browser:browser:${Versions.chromeTab}")
}