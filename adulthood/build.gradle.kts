plugins{
    kotlin("jvm")
    `maven-publish`
    id("org.springframework.boot") version "2.6.4"
}

repositories {
    mavenLocal()
    mavenCentral()
}

group = "my.den"
version = "1.0.0"

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

dependencies {
    implementation(platform("org.springframework.boot:spring-boot-dependencies:2.6.4"))
    implementation("org.springframework.boot:spring-boot-starter")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}
