package com.sivan.sbaceman.ui.viewstate

import com.sivan.sbaceman.data.remote.dto.SpaceResult

sealed class HomeViewState(
    open val data: SpaceResult = SpaceResult(space_data = emptyList(), users = emptyList()),
    open val isLoading: Boolean = false
) {

    /**
     * The initial state of the screen before performing the search.
     */
    object Initial : HomeViewState()

    /**
     * The state of the screen as the search is performed.
     */
    object Submitted : HomeViewState(isLoading = true)

    /**
     * The state of the screen when there is an error.
     */
    data class SearchError(
        val errorMessage: String,
    ) : HomeViewState(
        isLoading = false,
    )

    data class Success(
        val result: SpaceResult
    ) : HomeViewState(
        isLoading = false,
    )
}
