package com.sivan.sbaceman.data.repository

import com.haroldadmin.cnradapter.NetworkResponse
import com.sivan.sbaceman.data.remote.SbacemanApi
import com.sivan.sbaceman.data.remote.dto.ErrorResponse
import com.sivan.sbaceman.data.remote.dto.SpacesResponse
import com.sivan.sbaceman.domain.model.SearchOptions
import com.sivan.sbaceman.domain.repository.SbacemanRepository
import javax.inject.Inject


class SbaceRepoImpl @Inject constructor(
    private val api : SbacemanApi
) : SbacemanRepository{

    override suspend fun searchSpaces(searchOptions: SearchOptions): NetworkResponse<SpacesResponse, ErrorResponse> {
        return api.getSpaces(searchOptions)
    }
}