package com.example.doctorappointment.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.doctorappointment.R


@Composable
fun HomeHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 24.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(
                    horizontal = 16.dp
                )
        ) {
            Text(
                text = "Hi, Lozova Alina",
                color = colorResource(R.color.black),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "How are you today?",
                color = colorResource(R.color.black),
                modifier = Modifier
                    .padding(
                        top = 8.dp
                    )
            )
        }
        Image(
            painter = painterResource(R.drawable.bell_icon),
            contentDescription = null,
            modifier = Modifier
                .size(42.dp)
        )
    }
}

@Composable
@Preview
fun HomeHeaderPreview() {
    HomeHeader()
}