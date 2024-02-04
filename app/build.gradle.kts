plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")


    /////////----------------   for dagger ----------///////
//    id("kotlin-kapt")
//    id("com.google.gms.google-services")  //// dagger2

    kotlin("kapt")     ////for dagger hilt
    id("com.google.dagger.hilt.android")   ////for dagger hilt
    /////////----------------   for dagger ----------///////
}

android {
    namespace = "com.example.interview"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.interview"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

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
        dataBinding = true
    }

    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    val daggerVersion = "2.50"
    val firebaseVersion = "23.4.0"
    val retrofitVersion = "2.9.0"
    val coroutinesVersion = "1.7.1"
    val viewModelLifeCycleVersion = "2.7.0"

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    /////////----------------   for dagger ----------///////
//    implementation("com.google.dagger:dagger:$daggerVersion")       //// for dagger 2
//    kapt("com.google.dagger:dagger-compiler:$daggerVersion")        //// for dagger 2

    implementation("com.google.dagger:hilt-android:$daggerVersion")   ////for dagger hilt
    kapt("com.google.dagger:hilt-android-compiler:$daggerVersion")    ////for dagger hilt
    /////////----------------   for dagger ----------///////

    /////////// firebase push notification
    implementation("com.google.firebase:firebase-messaging:$firebaseVersion")

    ////////// retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    ////////// coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
    //implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$viewModelLifeCycleVersion")
   // implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")




    val lifecycle_version = "2.2.0-rc03"
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    kapt ("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")
}