import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.4"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"

    id("my-plugin")

    id("org.barfuin.gradle.taskinfo") version "2.0.0"
}

group = "denis.korotchenko"
version = "0.0.1-SNAPSHOT"


java.sourceCompatibility = JavaVersion.VERSION_17
java.withSourcesJar()


repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:2021.0.1"))
    implementation(platform("org.springframework.boot:spring-boot-dependencies:2.6.4"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter")

    implementation(project("adulthood"))

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.4")

    implementation("org.springdoc:springdoc-openapi-ui:1.6.11")

    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-reflect:1.7.10")
}


tasks {
    withType<KotlinCompile>().configureEach {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }
    withType<Test>().configureEach {
        useJUnitPlatform()
    }

}
