package com.invictus.meditationmind.features.mainActivityPage

sealed class Routes(val route: String) {
    object Listening : Routes("Listening/{id}") {
        fun createRoute(id: String) = "Listening/$id"
    }
    object WelcomePage: Routes("WelcomePage")
    object Home: Routes("Home")
    object MostPopular: Routes("MostPopular")
    object SettingPage: Routes("SettingPage")
}
