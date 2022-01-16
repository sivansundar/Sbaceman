package com.sivan.sbaceman.presentation.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sivan.sbaceman.presentation.home_screen.components.SearchBar

@Composable
fun HomeScreen(modifier: Modifier) {
    Box(modifier = modifier) {
        Column(modifier = Modifier.align(Alignment.TopCenter)) {

            SearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    ),
                hint = "Search for a space",
                onSearchButtonClicked = {
                }
            )
        }
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
