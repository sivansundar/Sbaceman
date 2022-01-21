package com.sivan.sbaceman.ui.viewstate

import com.sivan.sbaceman.data.remote.dto.Meta
import com.sivan.sbaceman.data.remote.dto.SpaceResult

sealed class HomeViewState {
    object INITIAL : HomeViewState()
    object LOADING : HomeViewState()
    data class SUCCESS(val data: SpaceResult = SpaceResult(space_data = listOf(), meta = Meta(result_count = 0))) : HomeViewState()
    data class FAILURE(val error: String) : HomeViewState()
}
