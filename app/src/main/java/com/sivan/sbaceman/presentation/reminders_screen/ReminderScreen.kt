package com.sivan.sbaceman.presentation.reminders_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RemindersScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = "Welcome to Reminders", style = MaterialTheme.typography.titleMedium)
        }
    }
}