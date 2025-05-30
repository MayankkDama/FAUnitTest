pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

val repoDir = providers.gradleProperty("repoDir").orNull ?: "${rootDir}/marketkit/build/repos/maven"

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        maven {
            setUrl("https://github.com/Gainsight/px-android/raw/main/")
        }
        maven {
            url = uri(repoDir)
        }
        maven {
            setUrl("https://jitpack.io")
        }
    }
}

rootProject.name = "FieldAlytics"
include(":app")

include(":common:ui")
include(":common:data")
include(":common:utils")
include(":common:domain")

include(":main-bottom-bar:ui")

include(":settings:ui")

include(":profiles:ui")

include(":onboarding:ui")
include(":onboarding:data")
include(":onboarding:domain")

include(":dashboard:ui")
include(":dashboard:data")
include(":dashboard:domain")

// include(":MarketKit-Android")
