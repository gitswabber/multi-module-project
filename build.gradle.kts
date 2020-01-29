plugins {
    id("com.bmuschko.docker-spring-boot-application") version "6.1.3" apply false
}

allprojects {
    apply {
        plugin("java")
        plugin("idea")
    }

    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    tasks.withType<Test> {
        systemProperty("file.encoding", "UTF-8")
    }
}
