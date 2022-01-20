package com.sivan.sbaceman.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haroldadmin.cnradapter.NetworkResponse
import com.sivan.sbaceman.data.remote.dto.ErrorResponse
import com.sivan.sbaceman.data.remote.dto.SpaceData
import com.sivan.sbaceman.data.remote.dto.SpacesResponse
import com.sivan.sbaceman.domain.model.SearchOptions
import com.sivan.sbaceman.domain.usecases.SearchSpaceUseCase
import com.sivan.sbaceman.ui.viewstate.HomeViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val searchSpaceUseCase: SearchSpaceUseCase
) : ViewModel() {

    private val _viewState: MutableStateFlow<HomeViewState> =
        MutableStateFlow(HomeViewState.INITIAL)
    val viewState: StateFlow<HomeViewState> = _viewState

    val spaces: MutableState<List<SpaceData>> = mutableStateOf(listOf())

    fun searchSpaces(searchOptions: SearchOptions) {
        _viewState.value = HomeViewState.LOADING
        viewModelScope.launch {
            searchSpaceUseCase.invoke(searchOptions = searchOptions).collect {
                handleResult(it)
            }
        }
    }

    private fun handleResult(data: NetworkResponse<SpacesResponse, ErrorResponse>) {
        _viewState.value = when (data) {
            is NetworkResponse.Success -> {
                HomeViewState.SUCCESS(
                    data = data.body.data
                )
            }

            is NetworkResponse.ServerError -> {
                HomeViewState.FAILURE(
                    error = data.body?.message.toString()
                )
            }

            is NetworkResponse.NetworkError -> {
                HomeViewState.FAILURE(
                    error = data.error.message.toString()
                )
            }
            is NetworkResponse.UnknownError -> {
                HomeViewState.FAILURE(
                    error = data.error.message.toString()
                )
            }
        }
    }
}
