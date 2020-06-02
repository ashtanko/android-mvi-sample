import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

plugins {
    id("com.android.application")
}

android {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    compileSdkVersion(29)

    defaultConfig {
        applicationId = "dev.shtanko.mvi"
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }

    bundle {
        language {
            enableSplit = true
        }

        density {
            enableSplit = true
        }

        abi {
            enableSplit = true
        }
    }

    lintOptions {
        isAbortOnError = false
        isWarningsAsErrors = false
        isCheckDependencies = true
        isIgnoreTestSources = true
        setLintConfig(file("lint.xml"))
        disable("GradleDeprecated")
        disable("OldTargetApi")
        disable("GradleDependency")
        disable("UnsafeExperimentalUsageError")
        disable("UnsafeExperimentalUsageWarning")
        disable("DuplicateIncludedIds")
    }

    // kotlinOptions {
    //     // "this" is currently lacking a proper type
    //     // See: https://youtrack.jetbrains.com/issue/KT-31077
    //     val options = this as? org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
    //     options?.jvmTarget = JavaVersion.VERSION_1_8.toString()
    // }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.72")
    implementation("com.google.android.material:material:1.1.0")
    implementation("androidx.appcompat:appcompat:1.3.0-alpha01")
    implementation("androidx.core:core:1.4.0-alpha01")
}