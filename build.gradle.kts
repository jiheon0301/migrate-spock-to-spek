buildscript {
    val kotlinVersion = "1.3.11"
    val springBootVersion = "2.1.1.RELEASE"

    repositories {
        maven("http://nexus.woowa.in/content/groups/public")
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion") // kotlin-spring 사용을 위해 필요하다.
        classpath("org.jetbrains.kotlin:kotlin-noarg:$kotlinVersion") // kotlin-spring 사용을 위해 필요하다.
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
    }
}

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.11" // 코틀린 DSL을 사용하기 위해서 여기에 선언해줘야 한다. ㅡ_-);; apply {} 에서 선언한 건 안먹음
}

apply {
    plugin("kotlin")
    plugin("kotlin-spring")
    plugin("kotlin-kapt") //https://kotlinlang.org/docs/reference/kapt.html
    plugin("idea")
    plugin("eclipse")
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
}

tasks {
    compileKotlin {
        kotlinOptions {
            freeCompilerArgs = mutableListOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
        dependsOn(processResources)
    }
    compileTestKotlin {
        kotlinOptions {
            freeCompilerArgs = mutableListOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }
}


group = "io.honeymon.training"
version = "1.0.0.SNAPSHOT"

repositories {
    maven("http://nexus.woowa.in/content/groups/public")
    maven("https://dl.bintray.com/spekframework/spek-dev")
}

val spekVersion = "2.0.0-alpha.1"

dependencies {
    // For Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    kapt("org.springframework.boot:spring-boot-configuration-processor")

    // Spring Boot Starter
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")

    runtimeOnly("com.h2database:h2")

    // For Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // SPEK Framework: https://spekframework.org/
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spekVersion") {
        exclude(group = "org.jetbrains.kotlin")
    }
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spekVersion") {
        exclude(group = "org.junit.platform")
        exclude(group = "org.jetbrains.kotlin")
    }
}