package com.example.doctorappointment.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.doctorappointment.core.ViewModel.MainViewModel
import com.example.doctorappointment.navigation.routes.detailRoute
import com.example.doctorappointment.navigation.routes.homeRoute
import com.example.doctorappointment.navigation.routes.introRoute
import com.example.doctorappointment.navigation.routes.topDoctorsRoute

@Composable
fun AppNavGraph(
    navController: NavHostController,
    viewModel: MainViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Intro.route
    ) {
        introRoute(
            onStart = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Intro.route) {
                        inclusive = true
                    }
                }
            }
        )

        homeRoute(
            viewModel = viewModel,
            onOpenDetail = { doctorModel ->
                navController.navigateToDetail(doctorModel)
            },
            onOpenTopDoctors = { navController.navigate(Screen.TopDoctor.route) }
        )

        topDoctorsRoute(
            viewModel = viewModel,
            onBack = { navController.popBackStack() },
            onOpenDetail = { doctorModel ->
                navController.navigateToDetail(doctorModel)
            }
        )

        detailRoute(
            navController = navController,
            onBack = { navController.popBackStack() }
        )
    }
}