import com.gradle.scan.plugin.BuildScanExtension

plugins {
    id("org.asciidoctor.jvm.gems") version "3.3.2"
    id("org.asciidoctor.jvm.convert") version "3.3.2"
}

repositories {
    mavenCentral()
}

// Configure the `asciidoctor` task
tasks.asciidoctor {
    sources("index.adoc")
    sourceDirProperty.set(layout.projectDirectory.dir("docs"))
    outputDirProperty.set(layout.buildDirectory.dir("docs"))
}

// Add `gemPath` as custom value
tasks.asciidoctor {
    doFirst {
        val buildScanApi = project.extensions.findByName("buildScan") as BuildScanExtension
        buildScanApi.value("$identityPath#gemPath", inputs.properties["gemPath"].toString())
    }
}
