package com.dbeqiraj.data.repository

import com.dbeqiraj.domain.repository.CakeRepository
import com.dibeqiraj.cakeapp.mvp.model.CakesResponse
import javax.inject.Inject

class CakesRepositoryImpl @Inject constructor(
    private val cakesApiService: CakesApiService
) : CakeRepository {

    override suspend fun getCakes(): CakesResponse {
        return cakesApiService.getCakes()
    }

}