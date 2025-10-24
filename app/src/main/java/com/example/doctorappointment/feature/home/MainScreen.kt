package com.example.doctorappointment.feature.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.doctorappointment.core.ViewModel.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val categories by viewModel.category.observeAsState(emptyList())
    val doctors by viewModel.doctor.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        if (categories.isEmpty())
            viewModel.loadCategory()
        if (doctors.isEmpty())
            viewModel.loadDoctor()
    }

    var selectedBottom by remember { mutableStateOf(0) }

    Scaffold(
        containerColor = Color.White,
        bottomBar = {
            HomeBottomBar(
                selected = selectedBottom,
                onSelect = { selectedBottom = it }
            )
        }
    ) { inner ->
        LazyColumn(
            contentPadding = inner
        ) {
            item { HomeHeader() }
            item { Banner() }
            item { SectionHeader(title = "Doctor Speciality", onSeeAll = null) }
            item { CategoryRow(items = categories) }
            item { SectionHeader(title = "Doctor Speciality", onSeeAll = null) }
            item { DoctorRow(items = doctors, onClick = {}) }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    val viewModel: MainViewModel = viewModel()
    MainScreen(viewModel)
}