plugins {
    application
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.javafx)
    alias(libs.plugins.jlink)
}

group = "ca.pragmaticcoding"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val moduleName = "ca.pragmaticcoding"

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

interface InjectedFs {
    @get:Inject val fs: FileSystemOperations
}

// Kotlin and Java sources share one JPMS module: let javac see the Kotlin classes,
// then merge them into the module's output directory so they are part of the
// module at runtime (run, jar, jlink) and not left on the classpath.
tasks.compileJava {
    val module = moduleName
    val kotlinClasses = tasks.compileKotlin.flatMap { it.destinationDirectory }
    val javaClasses = destinationDirectory
    val injected = objects.newInstance<InjectedFs>()
    options.compilerArgumentProviders.add(
        CommandLineArgumentProvider {
            listOf("--patch-module", "$module=${kotlinClasses.get().asFile.absolutePath}")
        }
    )
    doLast {
        injected.fs.copy {
            from(kotlinClasses)
            into(javaClasses)
        }
    }
}

// Kotlin classes are present in both output dirs after the merge above.
tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

application {
    mainModule = moduleName
    mainClass = "ca.pragmaticcoding.multimvci.Main"
    applicationDefaultJvmArgs = listOf("--enable-native-access=javafx.graphics")
}

javafx {
    version = libs.versions.javafx.get()
    modules("javafx.controls")
}

dependencies {
    implementation(libs.gson)
    implementation(libs.slf4j.api)
    runtimeOnly(libs.slf4j.simple)
}

jlink {
    imageZip = layout.buildDirectory.file("distributions/app-${javafx.platform.classifier}.zip")
    options = listOf("--strip-debug", "--compress", "zip-6", "--no-header-files", "--no-man-pages",
        // slf4j-simple is only found via ServiceLoader, so jlink would not include it on its own
        "--add-modules", "org.slf4j.simple")
    launcher {
        name = "app"
    }
}

tasks.jlinkZip {
    group = "distribution"
}
