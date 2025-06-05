plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.tops.tutorialapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.tops.tutorialapp"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
    configurations.all {
        resolutionStrategy {
            force("org.jetbrains:annotations:23.0.0")
            exclude(group = "com.intellij", module = "annotations")
        }
    }
}

dependencies {

    val room_version = "2.7.1"

    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-compiler:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")

    implementation(libs.org.jetbrains.annotations)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("org.jetbrains:annotations:23.0.0")

}