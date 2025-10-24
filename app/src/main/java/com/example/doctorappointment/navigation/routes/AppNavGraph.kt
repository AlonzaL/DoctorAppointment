package com.example.doctorappointment.navigation.routes

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.doctorappointment.core.ViewModel.MainViewModel
import com.example.doctorappointment.navigation.Screen
import com.example.doctorappointment.navigation.navigateToDetail
import com.example.doctorappointment.navigation.routes.introRoute

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
            onOpenDetail = {doctorModel ->
                navController.navigateToDetail(doctorModel)
            }
        )

        detailRoute(
            navController = navController,
            onBack = { navController.popBackStack() }
        )
    }
}