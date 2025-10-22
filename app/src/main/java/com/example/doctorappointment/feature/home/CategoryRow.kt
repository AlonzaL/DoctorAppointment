package com.example.doctorappointment.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.doctorappointment.R
import com.example.doctorappointment.feature.core.model.CategoryModel

@Composable
private fun CategoryItem(
    item: CategoryModel
) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(
                horizontal = 8.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .background(
                    color = colorResource(R.color.lightPurple)
                ),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = item.Pictere,
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = item.Name ?: "",
                color = colorResource(R.color.darkPurple)
            )
        }
    }
}

@Composable
@Preview
private fun CategoryItemPreview() {
    val item = CategoryModel(
        Id = 1,
        Name = "Category",
        Pictere = "picture_url"
    )
    CategoryItem(item = item)
}

@Composable
fun CategoryRow(
    items: List<CategoryModel>
) {
    Box(
        modifier = Modifier
            .heightIn(min = 100.dp)
    ) {
        if(items.isEmpty()) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
            )
        } else {
            LazyRow(
                contentPadding = PaddingValues(
                    horizontal = 16.dp
                ),
                modifier = Modifier
                    .padding(
                        top = 16.dp
                    )
            ) {
                items(items) { item ->
                    CategoryItem(item)
                }
            }
        }
    }
}