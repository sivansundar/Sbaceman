package com.sivan.sbaceman.presentation.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.SignalCellular4Bar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sivan.sbaceman.Constants
import com.sivan.sbaceman.domain.model.SearchParams
import com.sivan.sbaceman.presentation.home_screen.components.SearchBar
import com.sivan.sbaceman.presentation.home_screen.components.SpaceCard
import com.sivan.sbaceman.presentation.home_screen.components.SpaceTypeChipGroup
import com.sivan.sbaceman.ui.viewstate.HomeViewState
import java.util.Locale

@Composable
fun HomeContent(
    modifier: Modifier,
    viewState: HomeViewState,
    onSearchSubmit: (SearchParams) -> Unit = {}
) {

    Column(modifier = modifier) {

        var selectedType by remember {
            mutableStateOf("")
        }

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
            hint = "Search for a space",
            onSubmit = {
                if (selectedType.isNotBlank() && it.isNotBlank()) {
                    onSearchSubmit(
                        SearchParams(
                            title = it.lowercase(Locale.getDefault()),
                            state = selectedType.lowercase(Locale.getDefault())
                        )
                    )
                }
            }
        )

        SpaceTypeChipGroup(
            selectedType = selectedType,
            onSelectedChanged = {
                selectedType = it
            }
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            when (viewState) {
                is HomeViewState.LOADING -> CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.primary,
                    strokeWidth = 4.dp
                )
                is HomeViewState.FAILURE -> Text(text = "Error : ${viewState.error}")

                is HomeViewState.INITIAL -> {
                }
                is HomeViewState.SUCCESS -> {
                    if (viewState.data.meta.result_count > 0) {
                        LazyRow() {
                            items(viewState.data.space_data) { item ->
                                SpaceCard(
                                    modifier = Modifier
                                        .padding(vertical = 16.dp, horizontal = 12.dp)
                                        .width(300.dp)
                                        .height(325.dp),
                                    onSpaceClicked = {},
                                    spaceItem = item,
                                    backgroundColor = if (item.state == Constants.LIVE) MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.secondaryContainer
                                )
                            }
                        }
                    } else {
                        Text(text = "No results")
                    }
                }
            }
        }
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
