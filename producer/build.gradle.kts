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
version = "1.2.0"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("my.tim:logger:2.0.0")
}

