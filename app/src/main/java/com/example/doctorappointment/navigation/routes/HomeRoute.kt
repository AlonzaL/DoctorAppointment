package com.example.doctorappointment.navigation.routes

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.doctorappointment.core.ViewModel.MainViewModel
import com.example.doctorappointment.feature.home.MainScreen
import com.example.doctorappointment.navigation.Screen

fun NavGraphBuilder.homeRoute(
    viewModel: MainViewModel
) {
    composable(Screen.Home.route) {
        val categories by viewModel.category.observeAsState(emptyList())

        LaunchedEffect(Unit) {
            if(categories.isEmpty()) {
                viewModel.loadCategory()
            }
        }

        MainScreen(
            viewModel = viewModel
        )
    }
}