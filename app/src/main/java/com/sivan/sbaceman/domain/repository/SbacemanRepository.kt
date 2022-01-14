package com.sivan.sbaceman.domain.repository

import com.haroldadmin.cnradapter.NetworkResponse
import com.sivan.sbaceman.data.remote.dto.ErrorResponse
import com.sivan.sbaceman.data.remote.dto.SpacesResponse
import com.sivan.sbaceman.domain.model.SearchOptions

interface SbacemanRepository {

    suspend fun searchSpaces(searchOptions: SearchOptions) : NetworkResponse<SpacesResponse, ErrorResponse>

}