import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    id("maven-publish")
}

group = "com.newlibreria"
version = "2.2"

kotlin {
    androidTarget {
        publishLibraryVariants("release", "debug")
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        framework {
            baseName = "sharedLib"
            isStatic = true
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
    targets.withType<KotlinNativeTarget> {
        binaries.framework(listOf(RELEASE))
    }
}

android {
    namespace = "com.dfl.myapplicationlibrary"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}
publishing {
    repositories {
        mavenCentral()
    }
    publications {
        create<MavenPublication>("myArtifactdfl") {
            with(pom) {
                groupId = "com.newlibreria"
                artifactId = "esnetwork"
                packaging = "jar"
            }
        }
    }
}
//for import add
//exlib = { group = "com.newlibreria", name = "sharedLib", version.ref = "expeelib" }
//expeelib="{version}"