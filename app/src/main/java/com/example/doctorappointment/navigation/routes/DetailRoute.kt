package com.example.doctorappointment.navigation.routes

import android.R.attr.type
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.doctorappointment.core.model.DoctorModel
import com.example.doctorappointment.feature.detail.DetailScreen
import com.example.doctorappointment.navigation.Screen

fun NavGraphBuilder.detailRoute(
    navController: NavHostController,
    onBack: () -> Unit
) {
    composable(Screen.Detail.route) { backStackEntry: NavBackStackEntry ->
        val context = LocalContext.current
        val prevEntry = remember(navController) {
            navController.previousBackStackEntry
        }
        val doctor = remember(prevEntry) {
            prevEntry?.savedStateHandle?.get<DoctorModel>("doctor")
        }

        LaunchedEffect(prevEntry, doctor) {
            if (doctor == null) {
                onBack()
            } else {
                prevEntry?.savedStateHandle?.remove<DoctorModel>("doctor")
            }
        }

        if (doctor != null) {
            DetailScreen(
                item = doctor,
                onBack = onBack,
                onOpenWebsite = { url ->
                    context.startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(url)
                        )
                    )
                },
                onSendSms = { mobile, body ->
                    context.startActivity(
                        Intent(
                            Intent.ACTION_SENDTO,
                            Uri.parse("smsto:$mobile")
                        ).apply { putExtra("sms_body", body )}
                    )
                },
                onDial = { mobile ->
                    context.startActivity(
                        Intent(
                            Intent.ACTION_DIAL,
                            Uri.parse("tel: ${mobile.trim()}")
                        )
                    )
                },
                onDirection = { loc ->
                    context.startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(loc)
                        )
                    )
                },
                onShare = { subject, text ->
                    context.startActivity(
                        Intent.createChooser(
                            Intent(
                                Intent.ACTION_SEND
                            )
                                .apply {
                                    type = "text.plain"
                                    putExtra(Intent.EXTRA_SUBJECT, subject)
                                    putExtra(Intent.EXTRA_TEXT, text)
                                },
                            "choose one"
                        )
                    )
                }
            )
        } else {
            Spacer(modifier = Modifier.height(1.dp))
        }
    }
}