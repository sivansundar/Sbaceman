package com.sivan.sbaceman.domain.usecases

import com.haroldadmin.cnradapter.NetworkResponse
import com.sivan.sbaceman.data.remote.dto.ErrorResponse
import com.sivan.sbaceman.data.remote.dto.SpacesResponse
import com.sivan.sbaceman.domain.model.SearchOptions
import com.sivan.sbaceman.domain.repository.SbacemanRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchSpaceUseCase @Inject constructor(
    private val repository: SbacemanRepository
) {
    operator fun invoke(searchOptions: SearchOptions): Flow<NetworkResponse<SpacesResponse, ErrorResponse>> =
        flow {
            val data = repository.searchSpaces(searchOptions)
            emit(data)
        }
}
