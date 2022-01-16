package com.sivan.sbaceman.presentation.home_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SpaceTypeChip(
    modifier: Modifier,
    type: String
) {
    Surface(
        modifier = modifier,
        shadowElevation = 8.dp,
        tonalElevation = 8.dp,
        color = if (type == "Live") {
            MaterialTheme.colorScheme.tertiary
        } else MaterialTheme.colorScheme.secondary
    ) {
        Row(horizontalArrangement = Arrangement.Center) {
            Text(
                text = type,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
            )
        }
    }
}