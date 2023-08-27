pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "YassirMovies"
include(":app")
include(":Remote")
include(":Features")
include(":Features:Movies")
include(":Base")
include(":Local")
include(":Data")
include(":Domain")
include(":Model")
include(":Features:MovieDetails")
