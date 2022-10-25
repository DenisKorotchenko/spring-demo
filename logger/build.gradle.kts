plugins {
    kotlin("jvm")
    `maven-publish`
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

group = "my.tim"
version = "2.0.0"

repositories {
    mavenCentral()
}

