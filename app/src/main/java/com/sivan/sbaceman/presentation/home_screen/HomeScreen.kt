package com.sivan.sbaceman.presentation.home_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.SignalCellular4Bar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sivan.sbaceman.presentation.home_screen.components.SearchBar

@Composable
fun HomeScreen(modifier: Modifier) {
    Column(modifier = modifier) {

        Icon(
            imageVector = Icons.Rounded.SignalCellular4Bar, contentDescription = "Rocket",
            modifier = Modifier
                .size(180.dp)
                .align(Alignment.CenterHorizontally),
        )

        HeaderText(
            modifier = Modifier.padding(bottom = 10.dp),
            title = "S\uD83C\uDD71aceman",
            description = "Find your favourite Twitter Spaces and add a reminder so that you don't miss the important conversations"
        )

        SearchBar(
            modifier = Modifier.padding(bottom = 18.dp),
            hint = "Search for a space"
        )
    }
}

@Composable
fun HeaderText(modifier: Modifier, title: String, description: String) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.SemiBold),
        )

        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Composable
fun Footer(modifier: Modifier) {
    Box(modifier = modifier) {
        Text(
            text = "REMIND ME",
            modifier = Modifier.align(Alignment.Center),
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.surface
            )
        )
    }
}
