package com.sivan.sbaceman

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Money
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        val categoryList = listOf("Finance", "Health", "Chill", "Startup")
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly) {
            Text(text = "Welcome to S🅱️aceman!", style = MaterialTheme.typography.h3)
              LazyVerticalGrid(
                    cells = GridCells.Fixed(2)
                ) {
                    items(categoryList) { item ->
                        CategoryCard(item)
                    }
                }
            }
        }
    }

@Composable
fun CategoryCard(title: String) {
    Card(
        modifier = Modifier
            .height(200.dp)
            .padding(4.dp),
        shape =  RoundedCornerShape(18.dp),
        backgroundColor = Color(
            red = Random.nextInt(0, 255),
            green = Random.nextInt(0, 255),
            blue = Random.nextInt(0, 255)
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                imageVector = Icons.Rounded.Money,
                modifier = Modifier
                    .size(84.dp),
                contentDescription = null
            )

            Text(text = title, style = MaterialTheme.typography.subtitle1)
        }
    }
}


