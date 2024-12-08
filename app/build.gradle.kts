
import org.apache.tools.ant.util.JavaEnvUtils.VERSION_11

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.obo.opo.bomberos"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.obo.opo.bomberos"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    //SPLAH
    implementation("androidx.core:core-splashscreen:1.0.0")

    //Navigation compose
    implementation("androidx.navigation:navigation-compose:2.8.2")

    //DAGGER HILT
    implementation("com.google.dagger:hilt-android:2.48")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0-alpha01")
    implementation(libs.androidx.runtime.livedata)
    kapt("com.google.dagger:hilt-android-compiler:2.48")

    //GSON
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.3.0")
    //implementation("com.squareup.retrofit2:converter-gson.2.9.0")

    // ROOM
    implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    //MOSHI
    implementation("com.squareup.moshi:moshi-kotlin:1.15.1")

    //ROOM
    /*implementation("androidx.room:room-runtime:2.5.0")
    implementation("androidx.room:room-ktx:2.5.0")
    annotationProcessor("androidx.room:room-compiler:2.5.0")
    kapt("androidx.room:room-compiler:2.5.0")*/

    // DATA STORE
    implementation("androidx.datastore:datastore-preferences:1.1.1")

    // Font
    implementation("androidx.compose.ui:ui-text-google-fonts:1.7.5")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}

kapt {
    correctErrorTypes = true
}