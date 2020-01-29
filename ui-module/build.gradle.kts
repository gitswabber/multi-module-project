repositories {
    jcenter()
}

apply {
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
    plugin("com.bmuschko.docker-spring-boot-application")
}

apply(from = "../versions.gradle.kts")

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
}