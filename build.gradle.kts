plugins {
    kotlin("jvm") version "1.5.30"
}

group = "com.github.ichanzhar"
version = "0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.springframework:spring-core:5.2.8.RELEASE")
}