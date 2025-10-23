package com.example.doctorappointment.navigation

sealed class Screen(
    val route: String
) {
    data object Intro:Screen("intro")
    data object Home: Screen("home")
    data object TopDoctor: Screen("topDoctor")
    data object Detail:Screen("detail")
}