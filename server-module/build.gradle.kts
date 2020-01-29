repositories {
    jcenter()
}

plugins {
    id("net.ltgt.apt") version "0.21"
    id("net.ltgt.apt-idea") version "0.21"
//    id("io.freefair.lombok") version "3.0.0"
}

apply {
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
    plugin("com.bmuschko.docker-spring-boot-application")
}

apply(from = "../versions.gradle.kts")

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("com.h2database:h2:${project.extra["h2.version"]}")

    implementation("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    implementation("org.mapstruct:mapstruct:${project.extra["mapstruct.version"]}")
    annotationProcessor("org.mapstruct:mapstruct-processor:${project.extra["mapstruct.version"]}")

    implementation("com.google.guava:guava:${project.extra["guava.version"]}")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
