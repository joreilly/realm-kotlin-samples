buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
        classpath("com.android.tools.build:gradle:7.1.0-alpha02")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

group = "io.realm.sample.bookshelf"
version = "0.6.0"

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
