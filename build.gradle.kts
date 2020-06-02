buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:3.6.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

plugins {
    id("io.gitlab.arturbosch.detekt") version "1.9.1"
    id("com.diffplug.gradle.spotless") version "3.26.1"
    id("org.jetbrains.dokka") version "0.10.1"
}

detekt {
    config.from(file("config/detekt/detekt.yml"))
    parallel = true
    autoCorrect = true
}

tasks {

    // test {
    //     testLogging {
    //         events("passed", "skipped", "failed")
    //     }
    // }
    //
    // register<DokkaTask>("dokkaJavadoc") {
    //     outputFormat = "javadoc"
    //     outputDirectory = "$buildDir/javadoc"
    // }
    //
    // register<Jar>("javadocJar") {
    //     archiveClassifier.set("javadoc")
    //     dependsOn("dokkaJavadoc")
    //     from("$buildDir/javadoc")
    // }
    //
    // withType<JavaCompile>().configureEach {
    //     sourceCompatibility = JavaVersion.VERSION_1_8.toString()
    //     targetCompatibility = JavaVersion.VERSION_1_8.toString()
    // }
    //
    // withType<KotlinCompile>().configureEach {
    //     kotlinOptions {
    //         jvmTarget = JavaVersion.VERSION_1_8.toString()
    //         freeCompilerArgs = freeCompilerArgs + "-Xuse-experimental=kotlin.Experimental"
    //     }
    // }
    //
    // withType<Test>().configureEach {
    //     testLogging.showStandardStreams = true
    //     useJUnitPlatform()
    // }
    //
    // withType<Detekt>().configureEach {
    //     jvmTarget = JavaVersion.VERSION_1_8.toString()
    // }
    //
    // // config JVM target to 1.8 for kotlin compilation tasks
    // withType<KotlinCompile>().configureEach {
    //     kotlinOptions.jvmTarget = "1.8"
    // }
}