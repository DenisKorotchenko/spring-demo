import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.4"
    //id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"

    id("my-" + "plugin")

    idea
}

group = "denis.korotchenko"
version = "0.0.1-SNAPSHOT"


java.sourceCompatibility = JavaVersion.VERSION_17
java.withSourcesJar()


repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {

    integrationTestImplementation("org.jetbrains.kotlin:kotlin-reflect")


    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:2021.0.1"))
    implementation(platform("org.springframework.boot:spring-boot-dependencies:2.6.4"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
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


tasks.register("executeHello", JavaExec::class.java) {
    mainClass.set("TestKt")
    classpath = files(sourceSets.integrationTest.get().runtimeClasspath)

}
