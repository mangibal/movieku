plugins {
    id("com.android.dynamic-feature")
    kotlin("android")
    id("kotlin-parcelize")
    kotlin("kapt")
    id("kotlin-android")
}
android {
    compileSdkVersion(Apps.compileSdk)
    buildToolsVersion("30.0.2")

    defaultConfig {
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

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
    implementation(project(Modules.UTILS))
//    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
//    implementation("androidx.appcompat:appcompat:1.2.0")
//    implementation("com.google.android.material:material:1.3.0")
//    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
//    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
//    implementation("androidx.appcompat:appcompat:1.2.0")

    testImplementation("junit:junit:4.13.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}