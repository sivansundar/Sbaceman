package com.sivan.sbaceman.presentation.home_screen

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sivan.sbaceman.domain.model.SearchParams
import com.sivan.sbaceman.presentation.home_screen.components.SearchBar
import com.sivan.sbaceman.presentation.home_screen.components.SpaceTypeChipGroup
import com.sivan.sbaceman.ui.viewstate.HomeViewState

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
                            title = it,
                            state = selectedType
                        )
                    )
                }
            }
        )

        SpaceTypeChipGroup(
            selectedCar = selectedType,
            onSelectedChanged = {
                selectedType = it
            }
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
