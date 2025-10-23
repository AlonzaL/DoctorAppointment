package com.example.doctorappointment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.doctorappointment.core.ViewModel.MainViewModel
import com.example.doctorappointment.feature.home.MainScreen
import com.example.doctorappointment.navigation.routes.AppNavGraph
import com.example.doctorappointment.ui.theme.DoctorAppointmentTheme

class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val nav = rememberNavController()
            AppNavGraph(
                navController = nav,
                viewModel = mainViewModel
            )
        }
    }
}