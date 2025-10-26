package com.example.doctorappointment.navigation.routes

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.doctorappointment.core.ViewModel.MainViewModel
import com.example.doctorappointment.core.model.DoctorModel
import com.example.doctorappointment.feature.topdoctors.TopDoctorsScreen
import com.example.doctorappointment.navigation.Screen
import com.google.firebase.annotations.concurrent.Background

fun NavGraphBuilder.topDoctorsRoute(
    viewModel: MainViewModel,
    onBack: () -> Unit,
    onOpenDetail: (DoctorModel) -> Unit
) {
    composable(Screen.TopDoctor.route) {
        val doctors by viewModel.doctor.observeAsState(emptyList())

        LaunchedEffect(Unit) {
            if (doctors.isEmpty())
                viewModel.loadDoctor()
        }

        TopDoctorsScreen(
            doctors = doctors,
            onBack = onBack,
            onOpenDetail = onOpenDetail
        )
    }
}