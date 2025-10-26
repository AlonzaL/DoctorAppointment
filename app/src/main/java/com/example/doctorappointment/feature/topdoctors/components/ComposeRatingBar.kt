package com.example.doctorappointment.feature.topdoctors.components

import android.content.res.ColorStateList
import android.widget.RatingBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import android.R as AndroidR

@Composable
fun ComposeRatingBar(
    rating: Float,
    stars: Int = 5
) {
    var startTint = Color(0xffffc168).toArgb()

    AndroidView(
        factory = { context ->
            RatingBar(context, null, AndroidR.attr.ratingBarStyleSmall).apply {
               setNumStars(stars)
                setStepSize(0.5f)
                setIsIndicator(true)
                progressTintList = ColorStateList.valueOf(startTint)

            }
        },
        update = { rb ->
            rb.setRating(rating)
        }
    )
}

@Preview
@Composable
fun ComposeRatingBarPreview() {
    ComposeRatingBar(
        rating = 3.5f,
        stars = 5
    )
}