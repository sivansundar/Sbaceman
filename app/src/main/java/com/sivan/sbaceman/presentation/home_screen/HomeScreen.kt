package com.sivan.sbaceman.presentation.home_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.sivan.sbaceman.domain.model.SearchOptions
import com.sivan.sbaceman.presentation.MainViewModel

@Composable
fun HomeScreen(
    modifier: Modifier,
    viewModel: MainViewModel = hiltViewModel(),
) {
    val viewState by viewModel.viewState.collectAsState()

    HomeContent(
        modifier = modifier,
        viewState = viewState,
        onSearchSubmit = {
            viewModel.searchSpaces(SearchOptions(it))
        }
    )
}
