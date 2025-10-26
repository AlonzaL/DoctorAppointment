package com.example.doctorappointment.feature.topdoctors

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.doctorappointment.R
import com.example.doctorappointment.core.model.DoctorModel
import com.example.doctorappointment.feature.topdoctors.components.DoctorRowCard

@Composable
fun TopDoctorsScreen(
    doctors: List<DoctorModel>,
    onBack: () -> Unit,
    onOpenDetail: (DoctorModel) -> Unit,
    isLoading: Boolean = false
) {
    val listState = rememberLazyListState()
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .statusBarsPadding()
                        .padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        )
                        .height(56.dp)
                ) {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.back),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }

                    Text(
                        text = "Recomended List",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }

            items(
                items = doctors,
                key = { it.Name + "_" + it.Mobile ?: "" }
            ) { doc ->
                DoctorRowCard(
                    item = doc,
                    onMakeClick = { onOpenDetail(doc) }
                )
            }
        }

        when {
            isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }

            doctors.isEmpty() -> {
                Text(
                    text = "it's Empty",
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
    }
}

@Preview
@Composable
fun TopDoctorsScreenPreview() {
    val doctors = listOf(
        DoctorModel(
            Name = "Doctor",
            Special = "fff",
            Rating = 4.5,
            Picture = "",
            Mobile = "456"
        ),
        DoctorModel(
            Name = "Doctor",
            Special = "fff",
            Rating = 4.5,
            Picture = "",
            Mobile = "456"
        ),
        DoctorModel(
            Name = "Doctor",
            Special = "fff",
            Rating = 4.5,
            Picture = "",
            Mobile = "456"
        )
    )
    TopDoctorsScreen(
        doctors = doctors,
        onBack = {},
        onOpenDetail = {},
        isLoading = false
    )
}