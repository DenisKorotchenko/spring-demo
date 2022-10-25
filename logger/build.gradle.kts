plugins {
    kotlin("jvm")
    `maven-publish`
}

java{
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

group = "my.tim"
version = "1.0.0"

repositories {
    mavenCentral()
}

