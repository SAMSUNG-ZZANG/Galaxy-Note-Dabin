plugins {
    id("com.android.application")
    id("kotlin-parcelize")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization") version Versions.kotlinVersion
    id("androidx.navigation.safeargs.kotlin")
    id("org.jlleitschuh.gradle.ktlint") version Versions.ktlintVersion
    id("dagger.hilt.android.plugin")
}

android {
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":shared"))
    implementation(project(":feature:auth"))
    implementation(project(":feature:home"))
    implementation(project(":data"))
    implementation(project(":domain"))

    // Kotlin
    implementation(KotlinDependencies.kotlin)
    implementation(KotlinDependencies.kotlinxSerialization)
    implementation(KotlinDependencies.dateTime)

    // Android Core
    implementation(AndroidXDependencies.coreKtx)
    implementation(AndroidXDependencies.appCompat)
    implementation(AndroidXDependencies.constraintLayout)
    implementation(AndroidXDependencies.legacy)
    implementation(AndroidXDependencies.coroutines)
    implementation(AndroidXDependencies.roomKtx)
    coreLibraryDesugaring(AndroidXDependencies.desugarLibrary)

    // Material Design
    implementation(MaterialDesignDependencies.materialDesign)

    // Dagger-Hilt
    implementation(AndroidXDependencies.hilt)
    kapt(KaptDependencies.hiltCompiler)

    // Jetpack Navigation Component
    implementation(AndroidXDependencies.navigationFragment)
    implementation(AndroidXDependencies.navigationUI)

    // Jetpack Security
    implementation(AndroidXDependencies.security)

    // Jetpack Fragment
    implementation(AndroidXDependencies.fragment)

    // Jetpack Lifecycle
    implementation(AndroidXDependencies.coroutines)
    implementation(AndroidXDependencies.lifeCycleKtx)
    implementation(AndroidXDependencies.lifecycleJava8)

    // Jetpack Compose
    implementation(AndroidXDependencies.composeRuntime)

    // ImageLoading Library
    // Glide for general
    // Coil for compose
    implementation(ThirdPartyDependencies.glide)
    kapt(KaptDependencies.glideCompiler)
    implementation(ThirdPartyDependencies.coil)
    implementation(ThirdPartyDependencies.coilGif)

    // Http Client Library
    implementation(ThirdPartyDependencies.retrofit)
    implementation(platform(ThirdPartyDependencies.okHttpBom))
    implementation(ThirdPartyDependencies.okHttp)
    implementation(ThirdPartyDependencies.okHttpLoggingInterceptor)
    implementation(ThirdPartyDependencies.kotlinxSerializationConverter)

    // Logger - Timber
    implementation(ThirdPartyDependencies.timber)

    // Automatic Record OpenSource Library List
    implementation(ThirdPartyDependencies.ossLicense)

    // lottie
    implementation(ThirdPartyDependencies.lottie)

    // Paris: Apply Styles Programmatically
    implementation(ThirdPartyDependencies.paris)
    kapt(KspDependencies.parisCompiler)

    // Flipper
    debugImplementation(ThirdPartyDependencies.flipper)
    debugImplementation(ThirdPartyDependencies.flipperNetwork)
    debugImplementation(ThirdPartyDependencies.soloader)
    debugImplementation(ThirdPartyDependencies.flipperLeakCanary)
    debugImplementation(ThirdPartyDependencies.leakCanary)

    // Test Dependency
    testImplementation(TestDependencies.androidTest)
    testImplementation(TestDependencies.jUnit)
    testImplementation(TestDependencies.espresso)
}

ktlint {
    android.set(true)
    coloredOutput.set(true)
    verbose.set(true)
    outputToConsole.set(true)
    disabledRules.set(setOf("max-line-length", "no-wildcard-imports", "import-ordering"))
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
    }
}
