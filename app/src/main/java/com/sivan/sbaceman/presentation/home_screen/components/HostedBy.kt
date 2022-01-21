package com.sivan.sbaceman.presentation.home_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.sivan.sbaceman.data.remote.dto.User

@Composable
fun HostedBy(item: User) {
    androidx.compose.material3.Surface(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .size(50.dp),
        shape = CircleShape,
        border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.onSurface)
    ) {
        Image(
            painter = rememberImagePainter(data = item.profile_image_url),
            contentDescription = item.name,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
@Preview
fun HostedByPreview() {
    HostedByContainer(modifier = Modifier.fillMaxWidth(), users = emptyList())
}

@Composable
fun HostedByContainer(modifier: Modifier, users: List<User>) {
    LazyRow(modifier = modifier, horizontalArrangement = Arrangement.Center) {
        items(users) { item: User ->
            HostedBy(item)
        }
    }
}
