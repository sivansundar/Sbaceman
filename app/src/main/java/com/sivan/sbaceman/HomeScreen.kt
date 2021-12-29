package com.sivan.sbaceman

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(modifier: Modifier) {
    Box(modifier = modifier) {
        Column(modifier = Modifier.align(Alignment.Center)) {

            SearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    )
                ,
                hint = "Search for a space",
                onSearchButtonClicked = {

                })

        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier,
    hint: String,
    onSearchButtonClicked: (String) -> Unit
) {
    var searchText by rememberSaveable{ mutableStateOf("") }

    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    Box(modifier = modifier){
       BasicTextField(value = searchText, onValueChange = {
            searchText = it

        },
            singleLine = true,
            textStyle = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 16.dp)
                .onFocusChanged {
                    isHintDisplayed = !it.hasFocus
                },
        )

        if (isHintDisplayed && searchText.isEmpty() || searchText.isEmpty()) {
            Text(text = hint, modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(horizontal = 20.dp))
        }
    }
}

@Composable
@Preview
fun SearchBarPreview() {
    SearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        hint = "Search for a space",
        onSearchButtonClicked = {

        })
}

@Composable
fun SpaceTypeChip(
    type : String,
    onExecuteTypeChange : (String) -> Unit
) {
    Surface(
        modifier = Modifier
            .wrapContentSize()
            .clip(CircleShape),
        shadowElevation = 8.dp,
        tonalElevation = 8.dp,
        color = MaterialTheme.colorScheme.secondary
    ) {
        Row(modifier = Modifier
            .clickable { onExecuteTypeChange(type) }) {
            Text(text = type, modifier = Modifier.padding(8.dp), style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun SpaceTypeChipPreview(
) {
    SpaceTypeChip(type = "Scheduled") {

    }
}
