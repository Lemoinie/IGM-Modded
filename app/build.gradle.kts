plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

val gameName = "IdleGuildMaster"
val gameVersion = "2.148"
val modVersion = "1.3.8.8"

android {
    namespace = "it.paranoidsquirrels.idleguildmaster"
    compileSdk = 34

    defaultConfig {
        applicationId = "it.paranoidsquirrels.idleguildmaster.rebuilt"
        minSdk = 26
        targetSdk = 34
        versionCode = 159
        versionName = "$gameVersion-mod-$modVersion"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlinOptions {
        jvmTarget = "21"
    }

    testOptions {
        unitTests {
            isReturnDefaultValues = true
        }
    }

    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
        buildConfig = true
    }

    sourceSets {
        getByName("main") {
            java.srcDirs("src/main/java")
            kotlin.srcDirs("src/main/kotlin")
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    applicationVariants.all {
        outputs.all {
            val suffix = if (buildType.name == "debug") "-dev" else "-release"
            (this as? com.android.build.gradle.internal.api.BaseVariantOutputImpl)?.outputFileName =
                "${gameName}_v${gameVersion}_mod_v${modVersion}${suffix}.apk"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.drawerlayout:drawerlayout:1.2.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.viewpager2:viewpager2:1.1.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.work:work-runtime-ktx:2.9.1")

    // JSON
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")
    implementation("com.fasterxml.jackson.core:jackson-core:2.17.2")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.17.2")

    // ReactiveX
    implementation("io.reactivex.rxjava3:rxandroid:3.0.2")
    implementation("io.reactivex.rxjava3:rxjava:3.1.8")

    // TrueTime NTP
    implementation("com.github.instacart:truetime-android:3.5")

    // Google Play Services & Billing
    implementation("com.android.billingclient:billing:7.1.1")
    implementation("com.google.guava:guava:33.2.1-android")
    implementation("com.google.android.gms:play-services-ads:23.1.0")
    implementation("com.google.android.gms:play-services-games-v2:20.1.2")
    // Gson
    implementation("com.google.code.gson:gson:2.10.1")

    // Google Play In-App Review
    implementation("com.google.android.play:review:2.0.1")

    // Lifecycle KTX
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.4")

    // Testing
    testImplementation("junit:junit:4.13.2")

}
