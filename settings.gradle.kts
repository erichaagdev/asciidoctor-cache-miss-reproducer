plugins {
    id("com.gradle.enterprise") version "3.13.2"
    id("com.gradle.common-custom-user-data-gradle-plugin") version "1.10"
}

val isCI = !System.getenv("CI").isNullOrEmpty()

gradleEnterprise {
    server = "https://ge.solutions-team.gradle.com"
    buildScan {
        capture { isTaskInputFiles = true }
        isUploadInBackground = !isCI
        publishAlways()
    }
}

buildCache {
    local {
        isEnabled = true
    }

    remote(gradleEnterprise.buildCache) {
        isEnabled = true
        isPush = isCI
    }
}

rootProject.name = "asciidoctor-cache-miss-reproducer"
