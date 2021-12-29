package com.sivan.sbaceman

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sivan.sbaceman.ui.theme.SbacemanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SbacemanTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomBar(navController = navController)
                    }
                ) { innerPadding ->
                    NavHostSetup(navController, Modifier.padding(innerPadding))
                }

            }
        }
    }
}


@Composable
private fun NavHostSetup(navController: NavHostController, modifier: Modifier) {
    NavHost(navController = navController, startDestination = "home", modifier = modifier) {
        composable(Screen.Home.route) {
            //Home composable
            HomeScreen(
                modifier = Modifier.fillMaxSize().padding(12.dp)
            )
        }

        composable(Screen.Reminders.route) {
            //Favourites composable
            RemindersScreen()
        }
    }
}

@Composable
fun BottomBar(navController: NavController) {

    val items = listOf(
        Screen.Home,
        Screen.Reminders
    )

    BottomNavigation(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 5.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.map {
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.title
                    )
                },
                label = {
                    Text(
                        text = it.title
                    )
                },
                selected = currentRoute == it.route,
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(alpha = 0.4f),
                onClick = {
                    navController.navigate(it.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true

                        launchSingleTop = true

                    }
                }
            )
        }

    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SbacemanTheme {
        Greeting("Android")
    }
}