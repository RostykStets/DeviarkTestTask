plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.deviarktesttask"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.deviarktesttask"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.okhttp)
    implementation(libs.gson)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.glide)

    implementation(libs.androidx.room.runtime)

    // If this project uses any Kotlin source, use Kotlin Symbol Processing (KSP)
    // See Add the KSP plugin to your project
    //kapt(libs.androidx.room.compiler.v252)
    ksp(libs.androidx.room.compiler)

    // If this project only uses Java source, use the Java annotationProcessor
    // No additional plugins are necessary
    //annotationProcessor(libs.androidx.room.compiler)

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(libs.androidx.room.ktx)

    implementation(libs.androidx.lifecycle.extensions)

    implementation(libs.androidx.room.runtime.v250)
    implementation(libs.androidx.room.ktx.v250)
}