package com.sivan.sbaceman

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Timer
import androidx.compose.ui.graphics.vector.ImageVector


sealed class Screen(val route: String, val title : String, val icon : ImageVector) {
    object Home : Screen(route = "home", title = "Home", icon= Icons.Rounded.Home)
    object Search : Screen( route = "search", title = "Search", icon= Icons.Rounded.Search)
    object Reminders : Screen(route = "reminders", title = "Reminders", icon= Icons.Rounded.Timer)

}