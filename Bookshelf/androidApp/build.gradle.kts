plugins {
    id("com.android.application")
    kotlin("android")
}

val compose_version = "1.0.4"

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.constraintlayout:constraintlayout:2.1.1")
    implementation("androidx.compose.compiler:compiler:$compose_version")
    compileOnly("io.realm.kotlin:library:0.4.1")

    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.compose.ui:ui:$compose_version")
    implementation("androidx.compose.material:material:$compose_version")
    implementation("androidx.compose.ui:ui-tooling:$compose_version")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.4.0-rc01")
    implementation("androidx.navigation:navigation-runtime-ktx:2.3.5")
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha10")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.3.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0-rc01")
}

android {
    signingConfigs {
        getByName("debug") {
            keyAlias = "androiddebugkey"
            keyPassword = "android"
            storeFile = rootProject.file("debug.keystore")
            storePassword = "android"
        }
        // TODO create key for Playstore
//        create("release") {
//            keyAlias = "release"
//            keyPassword = "my release key password"
//            storeFile = file("release.keystore")
//            storePassword = "my keystore password"
//        }
    }
    compileSdk = 31
    defaultConfig {
        applicationId = "io.realm.sample.bookshelf.android"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs += "-Xallow-jvm-ir-dependencies"
    }

    composeOptions {
        kotlinCompilerVersion = "1.5.10"
        kotlinCompilerExtensionVersion = compose_version
    }
}
