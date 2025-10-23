package com.example.doctorappointment.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.doctorappointment.feature.intro.IntroScreen
import com.example.doctorappointment.navigation.Screen


fun NavGraphBuilder.introRoute(
    onStart: () -> Unit
) {
    composable(Screen.Intro.route) {
        IntroScreen(
            onStartClick = onStart
        )
    }
}