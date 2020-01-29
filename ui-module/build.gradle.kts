import com.moowork.gradle.node.task.NodeTask

repositories {
    mavenCentral()
    jcenter()
}

plugins {
        id("com.moowork.node") version "1.3.1"
//    id("com.github.node-gradle.node") version "2.2.0"
}

apply {
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
    plugin("com.bmuschko.docker-spring-boot-application")
}

apply(from = "../versions.gradle.kts")

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
//    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
}

node {
    //    version = "v9.9.0"
    download = true
    nodeModulesDir = file("${project.projectDir}/node_modules")
}

tasks.register<NodeTask>("buildReactApp") {
    dependsOn("npmInstall")
    setScript(project.file("node_modules/.bin/webpack"))
    setArgs(listOf("--mode", "development",
            "--entry", "./src/main/webapp/javascript/Main.jsx",
            "-o", "./src/main/resources/static/dist/react-app.js"))

    tasks.named<ProcessResources>("processResources") {
        dependsOn("buildReactApp")
    }
/*    configure<ProcessResources>() {
        dependsOn("buildReactApp")
    }*/
}


tasks.named<Delete>("clean") {
    delete("node_modules")
    delete("src/main/resources/static/dist")
}