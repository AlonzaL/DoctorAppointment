package com.example.doctorappointment.navigation

import androidx.navigation.NavController
import com.example.doctorappointment.core.model.DoctorModel

fun NavController.navigateToDetail(
    doctor: DoctorModel
) {
    currentBackStackEntry?.savedStateHandle?.set("doctor", doctor)
    navigate(Screen.Detail.route)
}