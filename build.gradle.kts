plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
}

group = "org.near"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    flatDir {
        dirs("libs")
    }
}

val ktor_version: String by project
val logback_version: String by project
val koin_version: String by project
val cryptoKeyEd25519Version: String by project

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("io.ktor:ktor-client-logging:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation("io.insert-koin:koin-core:$koin_version")
    implementation("io.insert-koin:koin-ktor:$koin_version")
    implementation("com.syntifi.crypto:crypto-key-ed25519:$cryptoKeyEd25519Version")
    // implementation("io.github.funkatronics:kborsh:0.1.0")
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("borshj-*.jar"))))
}

tasks.test {
    useJUnitPlatform()
}
