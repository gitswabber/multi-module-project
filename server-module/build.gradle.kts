repositories {
    jcenter()
}

plugins {
    id("org.springframework.boot") version "2.2.4.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("net.ltgt.apt") version "0.21"
    id("net.ltgt.apt-idea") version "0.21"
    id("io.freefair.lombok") version "4.1.6"
}

apply {
    plugin("com.bmuschko.docker-spring-boot-application")
}

apply(from = "../versions.gradle.kts")

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("com.h2database:h2:${project.extra["h2.version"]}")

    implementation("org.mapstruct:mapstruct:${project.extra["mapstruct.version"]}")
    annotationProcessor("org.mapstruct:mapstruct-processor:${project.extra["mapstruct.version"]}")

    implementation("com.google.guava:guava:${project.extra["guava.version"]}")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.test {
    useJUnitPlatform()
}