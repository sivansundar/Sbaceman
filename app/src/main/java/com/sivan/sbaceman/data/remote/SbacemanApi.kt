package com.sivan.sbaceman.data.remote

import com.haroldadmin.cnradapter.NetworkResponse
import com.sivan.sbaceman.data.remote.dto.ErrorResponse
import com.sivan.sbaceman.data.remote.dto.SpacesResponse
import com.sivan.sbaceman.domain.model.SearchOptions
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * This interface contains all the necessary Retrofit calls
 * */

interface SbacemanApi {

    @POST("/v1/search")
    suspend fun getSpaces(@Body searchparams : SearchOptions) : NetworkResponse<SpacesResponse, ErrorResponse>
}