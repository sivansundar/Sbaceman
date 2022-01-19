package com.sivan.sbaceman.presentation.home_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.SupervisedUserCircle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sivan.sbaceman.R

@Composable
fun ParticipantCount(modifier: Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Rounded.SupervisedUserCircle,
            contentDescription = "Participant count",
            tint = MaterialTheme.colorScheme.onSecondaryContainer
        )
        Text(
            text = "50",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Composable
fun HostedBy() {
    androidx.compose.material3.Surface(
        modifier = Modifier.padding(horizontal = 5.dp).size(40.dp),
        shape = CircleShape,
        border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.onSurface)
    ) {
        Image(
            painterResource(id = R.drawable.user_image),
            contentDescription = "User image",
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
@Preview
fun HostedByPreview() {
    HostedByContainer(modifier = Modifier.fillMaxWidth())
}

@Composable
fun HostedByContainer(modifier: Modifier) {
    Row(modifier = modifier) {
        HostedBy()
        HostedBy()
        HostedBy()
    }
}
