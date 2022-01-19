package com.sivan.sbaceman.presentation.home_screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun SpaceTimings(modifier: Modifier, time: String) {
    Row(modifier = modifier) {
        Text(
            text = "Starts at $time",
            style = MaterialTheme.typography.labelMedium.copy(
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            ),

        )
    }
}
