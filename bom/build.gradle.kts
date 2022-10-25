plugins {
    `maven-publish`
    `java-platform`
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["javaPlatform"])
        }
    }
}

group = "my.tim"
version = "2.0.0"

dependencies {
    constraints {
        api("my.tim:logger:1.1.0")
        api("my.tim:producer:1.2.0")
        api("my.tim:parser:1.0.0")
    }
}
