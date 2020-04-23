package com.dbeqiraj.domain.repository

import com.dibeqiraj.cakeapp.mvp.model.CakesResponse

interface CakeRepository {
    suspend fun getCakes(): CakesResponse
}