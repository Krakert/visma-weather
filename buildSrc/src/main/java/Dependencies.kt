@file:Suppress("unused", "SpellCheckingInspection")

object Versions {
    const val kotlin = "1.8.10"
    const val gradle = "7.4.2"

    const val kotlinCoroutines = "1.6.4"

    const val daggerHilt = "2.48"
    const val hilt = "1.0.0"

    const val compose = "1.4.4"
    const val composeMaterial3 = "1.1.2"
    const val composeCompiler = "1.4.4"
    const val composeRuntime = "1.4.0"
    const val composeActivity = "1.7.0"
    const val composeWear = "1.1.0"
    const val composeNavigation = "2.7.4"
    const val composeViewModel = "2.5.0"
    const val composePreview = "1.4.0"
    const val composeIcon = "1.4.0"

    const val coil = "2.4.0"

    const val ktor = "2.2.4"
    const val napier = "2.6.1"
    const val serialization = "1.5.0"

}

object Projects {
    const val gradleTools = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val daggerHiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.daggerHilt}"
    const val serializationPlugin = "org.jetbrains.kotlin:kotlin-serialization:${Versions.serialization}"
}

object Deps {
    // Ktor
    const val ktorCore = "io.ktor:ktor-client-core:${Versions.ktor}"
    const val ktorClient = "io.ktor:ktor-client-android:${Versions.ktor}"
    const val ktorJvm = "io.ktor:ktor-client-core-jvm:${Versions.ktor}"
    const val ktorNeogotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
    const val ktorSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
    const val ktorJson = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
    const val ktorLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    const val napier = "io.github.aakira:napier:${Versions.napier}"

    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"

    // Compose to load images via coil
    const val composeCoil = "io.coil-kt:coil-compose:${Versions.coil}"

    // Share preference
    const val preference = "androidx.preference:preference:1.2.0"

    // Compose Navigation
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.composeNavigation}"
    const val composeHiltNavigation = "androidx.hilt:hilt-navigation-compose:1.0.0"

    const val composeMatertial3 = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val composeCompiler = "androidx.compose.compiler:compiler:${Versions.composeCompiler}"
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.composeRuntime}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val composeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeViewModel}"
    const val composePreview = "androidx.compose.ui:ui-tooling:${Versions.composePreview}"
    const val composeIcons = "androidx.compose.material:material-icons-core:${Versions.composeIcon}"

    //DI
    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
    const val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"
    const val daggerHiltJetpackCompiler = "androidx.hilt:hilt-compiler:${Versions.hilt}"
    const val daggerHiltCore = "com.google.dagger:hilt-core:${Versions.daggerHilt}"

    const val timber = "com.jakewharton.timber:timber:5.0.1"

}