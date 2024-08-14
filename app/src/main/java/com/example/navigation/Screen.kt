package com.example.navigation

sealed class Screen(val screen: String){

    data object Home: Screen("home")
    data object Profile: Screen("profile")
    data object Settings: Screen("settings")


}