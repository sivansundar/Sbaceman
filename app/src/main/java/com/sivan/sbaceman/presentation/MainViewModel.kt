package com.sivan.sbaceman.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.haroldadmin.cnradapter.NetworkResponse
import com.sivan.sbaceman.data.remote.dto.ErrorResponse
import com.sivan.sbaceman.data.remote.dto.SpaceData
import com.sivan.sbaceman.data.remote.dto.SpacesResponse
import com.sivan.sbaceman.domain.model.SearchOptions
import com.sivan.sbaceman.domain.usecases.SearchSpaceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val searchSpaceUseCase: SearchSpaceUseCase
) : ViewModel() {

    val spaces: MutableState<List<SpaceData>> = mutableStateOf(listOf())

    suspend fun searchSpaces(searchOptions: SearchOptions) {
        val data = searchSpaceUseCase.invoke(searchOptions = searchOptions).collect {
            handleResult(it)
        }
    }

    private fun handleResult(data: NetworkResponse<SpacesResponse, ErrorResponse>) {
        when (data) {
            is NetworkResponse.Success -> {
                // spaces.value = data.body.data
                Timber.d("Data : Data $data")
            }
            is NetworkResponse.ServerError -> {
                Timber.d("Error : Server Error ${data.body?.message}")
            }
            is NetworkResponse.NetworkError -> {
                Timber.d("Error : NetworkError ${data.error.message}")
            }
            is NetworkResponse.UnknownError -> {
                Timber.d("Error : UnknownError $data")
            }
        }
    }
}
